/**
 * Created by Hajay on 2016/4/22.
 */

var bcModules = bcModules || {};
var bcUtil = bcUtil || {};
(function (u) {
    'use strict';

}(bcUtil));
(function (m, u) {
    'use strict';
    var moduleName = "payDemo";
    m[moduleName] = angular.module(moduleName, []);

    m[moduleName].config(function ($httpProvider) {
        //对php的post处理
        $httpProvider.defaults.transformRequest = function (request) {
            if (typeof(request) != 'object') {
                return request;
            }
            var str = [];
            for (var k in request) {
                if (k.charAt(0) == '$') {
                    delete request[k];
                    continue;
                }
                var v = 'object' == typeof(request[k]) ? JSON.stringify(request[k]) : request[k];
                str.push(encodeURIComponent(k) + "=" + encodeURIComponent(v));
            }
            return str.join("&");
        };
        $httpProvider.defaults.timeout = 10000;
        $httpProvider.defaults.headers.post = {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-Requested-With': 'XMLHttpRequest'
        };
    })
        .controller("payDemoCtrl", ["$scope", "$http", function ($scope, $http) {

            $scope.price = "0.01";
            $scope.selShirt = "white";
            $scope.selColor = "white";
            $scope.getShirt = function () {return "img/img-shirt-"+$scope.selShirt+".jpg"};

            $scope.getColor = function () {
                switch($scope.selColor) {
                    case "white":
                        return "白色";
                    case "gray":
                        return "灰色";
                    case "blue":
                        return "蓝色";
                }
            };
            $scope.showWebPay = false;
            $scope.showWapPay = false;
            $scope.showAndroid = false;
            $scope.wPayViewPosition = {
                "transform": "translate3d(0px,0,0)",
                "-webkit-transform":"translate3d(0px,0,0)",
                "-o-transform": "translate3d(0px,0,0)",
                "-ms-transform":"translate3d(0px,0,0)",
                "-moz-transform": "translate3d(0px,0,0)"
            };
            $scope.showPopup = false;
            $scope.number = 1;
            $scope.sizeSelected = 1;
            $scope.channel = 'WX_NATIVE';

            $scope.doChangeWebPayView = function(point) {
                $scope.wPayViewPosition = {
                    "transform": "translate3d(" + point +"px,0,0)",
                    "-webkit-transform": "translate3d(" + point +"px,0,0)",
                    "-o-transform": "translate3d(" + point +"px,0,0)",
                    "-ms-transform": "translate3d(" + point +"px,0,0)",
                    "-moz-transform": "translate3d(" + point +"px,0,0)"
                };
            }

            $scope.getSize = function () {
                var size = "M";
                switch($scope.sizeSelected) {
                    case 0:
                        size = "S";
                        break;
                    case 1:
                        size = "M";
                        break;
                    case 2:
                        size = "L";
                        break;
                    case 3:
                        size = "XL";
                        break;
                    default :
                        break;
                }
                return size;
            }

            $scope.isReSubmit = false;
			
			$scope.reportQuery = function () {
				window.open("/report.html");
			}

            $scope.goPay = function () {

                $scope.bill_no = "DemoPay" + new Date().getTime();
                $scope.title = "Future paymentGW DEMO T-Shirt";
                $scope.total_fee = $scope.number * 10;
                $scope.optional = {
                    size: "尺寸: " + $scope.getSize(),
                    number: $scope.number + "件",
                    color: "白色"
                };

                if (!$scope.isReSubmit) {
                    $scope.isReSubmit = true;
                    if ($scope.channel == "WX_NATIVE") {
                    	$http({
                    	    method: 'POST',
                    	    url: "/qrcodeurl",
                    	    data: {totalFee: "1"},
                    	    headers: {'Content-Type': 'application/json'}
                    	}).then(function(res) {
                    		var codeUrl = res.data.codeUrl;
                    		var orderNo = res.data.orderNo;
                            angular.element(".wechat").css("display","block");
                            var options = {text: codeUrl};
                            var canvas = BCUtil.createQrCode(options);
                            angular.element("#qrcode").append(canvas);
	                            $scope.int = self.setInterval(function(){
	                                $scope.billQuery(orderNo)
	                            }, 10000);
                            })
							angular.element(".wechat").css("display","block");
							
                    } else {
                        $scope.showPopup = true;
                        /*$("form").remove();
                        var html='<form id="pay" target="_blank" style="display:none" action="' + 'data/start.demo.pay.php" name="pay" method="post">' +
                            '<input type="hidden" name="channel" value="'+ $scope.channel +'"/>'+
                            '<input type="hidden" name="total_fee" value="'+ $scope.total_fee +'"/>'+
                            '<input type="hidden" name="bill_no" value="'+ $scope.bill_no +'"/>'+
                            '<input type="hidden" name="title" value="'+ $scope.title +'"/>'+
                            '<input type="submit" value="Submit">'+
                            '</form>';

                        angular.element("body").append(html);
                        angular.element("#pay").submit();*/
						if ($scope.channel == "ALI_WEB") {
							window.open("https://excashier.alipay.com/standard/auth.htm");
						}
						if ($scope.channel == "JD_WEB") {
							window.open("https://wepay.jd.com/jdpay/login");
						}
                    }
                }
            }

            $scope.billStatusStyle = {
                "color": "#21d376"
            }
            $scope.billStatus = "交易失败";
            $scope.queryTimes = 0;

            //订单查询
            $scope.billQuery = function(orderNo) {
            	
            	$http({
            	    method: 'POST',
            	    url: "/order/" + orderNo,
            	    headers: {'Content-Type': 'application/json'}
            	}).then(function (res) {
            		var orderStatus = res.data.orderStatus;
                    if (orderStatus == 'SUCCESS') {
                        var temp = new Date();
                        //temp.setTime(res.data[0].create_time);
                        $scope.billDate = temp.format('yyyy-MM-dd hh:mm');

                            if (orderStatus) {
                                if ($scope.channel == "WX_NATIVE") {
                                    $scope.queryTimes = 0;
                                    $scope.payCancel();
                                }
                                $scope.billStatusStyle = {
                                    "color": "#21d376"
                                }
                                $scope.bill_no = orderNo;
                                $scope.billStatus = "交易成功";
                                $scope.doChangeWebPayView(-3600);

                            } else {
                                if ($scope.channel == "WX_NATIVE" && $scope.queryTimes < 2400) {
                                    $scope.queryTimes++;
                                } else {
                                    $scope.payCancel();
                                    $scope.billStatusStyle = {
                                        "color": "#D0021B"
                                    }
                                    $scope.billStatus = "交易失败";
                                    $scope.doChangeWebPayView(-3600);
                                }
                            }
                        }
                })
            };

            $scope.payCancel = function () {
                angular.element(".wechat").css("display","none");
                angular.element("#qrcode canvas").remove();
                window.clearInterval($scope.int);
                $scope.isReSubmit = false;
            }

            $scope.paySuccess = function () {
                $scope.showPopup = false;
                $scope.isReSubmit = false;
				$scope.billStatusStyle = {
					"color": "#21d376"
				}
				$scope.billStatus = "交易成功";
                $scope.doChangeWebPayView(-3600);
            };

            $scope.payFail = function () {
                $scope.showPopup = false;
                $scope.isReSubmit = false;
            };

            Date.prototype.format = function (format) {
                var o = {
                    "M+": this.getMonth() + 1, //month
                    "d+": this.getDate(), //day
                    "h+": this.getHours(), //hour
                    "m+": this.getMinutes(), //minute
                    "s+": this.getSeconds(), //second
                    "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
                    "S": this.getMilliseconds() //millisecond
                }
                if (/(y+)/.test(format)) format = format.replace(RegExp.$1,
                    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
                for (var k in o)if (new RegExp("(" + k + ")").test(format))
                    format = format.replace(RegExp.$1,
                        RegExp.$1.length == 1 ? o[k] :
                            ("00" + o[k]).substr(("" + o[k]).length));
                return format;
            }

        }])

}(bcModules, bcUtil));
