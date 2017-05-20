keytool -genkey -alias oauth2 -keypass oauth2_pass -keyalg RSA -keysize 1024 -validity 365 -keystore /Users/Leo.yang/Downloads/oauth2.keystore -storepass oauth2_st_pass -dname "CN=future, OU=future, O=future, L=future, ST=future, C=CN"


keytool -list  -v -keystore /Users/Leo.yang/Downloads/oauth2.keystore -storepass oauth2_st_pass

keytool -export -alias yushan -keystore /Users/Leo.yang/Downloads/oauth2.keystore -file /Users/Leo.yang/Downloads/oauth2.crt -storepass oauth2_st_pass

