CREATE KEYSPACE IF NOT EXISTS sb_payment  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };

CREATE TYPE IF NOT EXISTS sb_payment.DeviceInfo(storeNo text, deviceNo text);
CREATE TYPE IF NOT EXISTS sb_payment.PaymentMethod(type text, externalKey text, accountId text);
CREATE TYPE IF NOT EXISTS sb_payment.OrderItem(itemId text, itemTitle text, quantity int, price decimal);
CREATE TYPE IF NOT EXISTS sb_payment.SalesOrder(orderId text, items list<FROZEN<OrderItem>>);


CREATE TABLE IF NOT EXISTS sb_payment.payment_request (
	id TimeUUID PRIMARY KEY, 
	deviceInfo FROZEN<DeviceInfo>,
	paymentMethod FROZEN<PaymentMethod>,
	saleOrder FROZEN<SalesOrder>
);

DROP TABLE payment_transaction;
CREATE TABLE IF NOT EXISTS sb_payment.payment_transaction (
	attemptId TimeUUID, 
	paymentId TimeUUID,
	transactionExternalKey text,
	transactionType varchar,
	effectiveDate timestamp,
	transactionStatus varchar,
	amount decimal,
	currency varchar,
	processedAmount decimal,
	processedCurrency varchar,
	gatewayErrorCode text,
	gatewayErrorMsg text, 
	primary key(attemptId, paymentId)
);

