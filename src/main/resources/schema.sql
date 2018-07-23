CREATE TABLE TimeRecords
(
   created_dt DATE,
   client VARCHAR(255),
   project VARCHAR(255),
   project_code VARCHAR(255),
   task VARCHAR(255),
   hours DECIMAL(9,2),
   hours_rounded DECIMAL(9,1),
   billable BOOLEAN,
   invoiced BOOLEAN,
   approved BOOLEAN,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   department VARCHAR(255),
   employee BOOLEAN,
   billable_rate INT,
   cost_rate INT,
   cost_ammount INT,
   currency VARCHAR(255),
   url VARCHAR(255)
);
