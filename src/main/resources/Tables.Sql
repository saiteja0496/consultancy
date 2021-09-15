CREATE TABLE Transaction_Details (
  tnx_id INT NOT NULL,
  account_number VARCHAR(255) NULL,
  transactionts VARCHAR(255) NULL,
  type VARCHAR(255) NULL,
  amount DOUBLE NULL,
  CONSTRAINT pk_transaction PRIMARY KEY (tnx_id)
);

CREATE TABLE Account (
  acc_id INT NOT NULL,
  account_number VARCHAR(255) NULL,
  lastupdatetimestamp VARCHAR(255) NULL,
  amount DOUBLE NULL,
  CONSTRAINT pk_account PRIMARY KEY (acc_id)
);

