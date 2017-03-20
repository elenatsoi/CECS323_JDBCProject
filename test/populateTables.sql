INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('AGroup', 'A Head', '1/1/2000', 'ASub');
INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('BGroup', 'B Head', '1/1/2001', 'BSub');
INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('CGroup', 'C Head', '1/1/2002', 'CSub');
INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('DGroup', 'D Head', '1/1/2003', 'DSub');
INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('EGroup', 'E Head', '1/1/2004', 'ESub');
INSERT INTO WRITINGGROUPS(groupName, headWriter, yearFormed, subject)
VALUES('FGroup', 'F Head', '1/1/2005', 'FSub');

INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('APublisher', 'A Address', '5625551111', 'a@email.com');
INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('BPublisher', 'B Address', '5625552222', 'b@email.com');
INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('CPublisher', 'C Address', '5625553333', 'c@email.com');
INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('DPublisher', 'D Address', '5625554444', 'd@email.com');
INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('EPublisher', 'E Address', '5625555555', 'e@email.com');
INSERT INTO PUBLISHERS(publisherName, publisherAddress, publisherPhone, publisherEmail)
VALUES('FPublisher', 'F Address', '5625556666', 'f@email.com');

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('AGroup', 'ABook1', 'APublisher', '1/1/2001', 101);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('AGroup', 'ABook2', 'APublisher', '1/1/2002', 201);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('AGroup', 'ABook3', 'APublisher', '1/1/2003', 301);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('BGroup', 'BBook1', 'BPublisher', '1/1/2001', 102);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('BGroup', 'BBook2', 'BPublisher', '1/1/2002', 202);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('BGroup', 'BBook3', 'BPublisher', '1/1/2003', 302);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('CGroup', 'CBook1', 'CPublisher', '1/1/2001', 103);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('CGroup', 'CBook2', 'CPublisher', '1/1/2002', 203);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('CGroup', 'CBook3', 'CPublisher', '1/1/2003', 303);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('DGroup', 'DBook1', 'DPublisher', '1/1/2001', 104);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('DGroup', 'DBook2', 'DPublisher', '1/1/2002', 204);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('DGroup', 'DBook3', 'DPublisher', '1/1/2003', 304);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('EGroup', 'EBook1', 'EPublisher', '1/1/2001', 105);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('EGroup', 'EBook2', 'EPublisher', '1/1/2002', 205);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('EGroup', 'EBook3', 'EPublisher', '1/1/2003', 305);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('FGroup', 'FBook1', 'FPublisher', '1/1/2001', 106);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('FGroup', 'FBook2', 'FPublisher', '1/1/2002', 206);
INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('FGroup', 'FBook3', 'FPublisher', '1/1/2003', 306);

INSERT INTO BOOKS(groupName, bookTitle, publisherName, yearPublished, numberPages)
VALUES('AGroup', 'TestDelete', 'APublisher', '1/1/2010', 110);