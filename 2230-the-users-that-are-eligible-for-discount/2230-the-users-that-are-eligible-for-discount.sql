CREATE PROCEDURE getUserIDs(startDate DATE, endDate DATE, minAmount INT)
BEGIN
	# Write your MySQL query statement below.
	select distinct P.user_id from Purchases P where (P.time_stamp  <=endDate and P.time_stamp>=startDate and P.amount>minAmount) order by user_id ASC;
END