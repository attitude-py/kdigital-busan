-- ������ ���� �Ӽ��� ���� NewBook ���̺��� �����Ͻÿ�,
-- �������� NUMBER��, �������� ������ ����Ÿ���� VARCHAR2�� ���
-- bookid(������ȣ) ? NUMBER
-- bookname(�����̸�) ? VARCHAR2(20)
-- publisher(���ǻ�) ? VARCHAR2(20)
-- price(����) ? NUMBER

CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
);

DROP TABLE NEWBOOK_OCH;

-- �ֽĺ��� ����
CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER -- PRIMARY KEY
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
    -- , PRIMARY KEY (BOOKID)
    -- , CONSTRAINT PK_NEWBOOK_OCH PRIMARY KEY (BOOKID)
    , PRIMARY KEY (BOOKID, BOOKNAME)
);
DESC NEWBOOK_OCH;
DROP TABLE NEWBOOK_OCH;

-- ��Ÿ ���� ���� : �⺻�� ����, CHECK ���� ����
CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER DEFAULT (0) CHECK(PRICE >= 0)
    , PRIMARY KEY (BOOKID)
);
DESC NEWBOOK_OCH;
DROP TABLE NEWBOOK_OCH;

-- ������ ���� �Ӽ��� ���� NewCustomer ���̺��� �����Ͻÿ�
--custid(������ȣ) - NUMBER, �⺻Ű
--name(�̸�) ? VARCHAR2(40)
--address(�ּ�) ? VARCHAR2(40)
--phone(��ȭ��ȣ) ? VARCHAR2(30)
CREATE TABLE NEWCUSTOMER_OCH
(
    CUSTID NUMBER
    , NAME VARCHAR2 (40)
    , ADDRESS VARCHAR2 (40)
    , PHONE VARCHAR2 (30)
    , PRIMARY KEY (CUSTID)
);
DESC NEWCUSTOMER_OCH;

--������ ���� �Ӽ��� ���� NewOrders ���̺��� �����Ͻÿ�.
--orderid(�ֹ���ȣ) - NUMBER, �⺻Ű
--custid(������ȣ) - NUMBER, NOT NULL ��������, �ܷ�Ű(NewCustomer.custid, �������)
--bookid(������ȣ) - NUMBER, NOT NULL ��������
--saleprice(�ǸŰ���) - NUMBER
--orderdate(�Ǹ�����) - DATE

CREATE TABLE NEWORDERS_OCH
(
    ORDERID NUMBER
    , CUSTID NUMBER NOT NULL
    , BOOKID NUMBER NOT NULL
    , SALEPRICE NUMBER NULL
    , ORDERDATE DATE NULL
    , PRIMARY KEY (ORDERID)
    , FOREIGN KEY (CUSTID) REFERENCES NEWCUSTOMER_OCH(CUSTID) ON DELETE CASCADE
    , CONSTRAINT FK_NEWBOOK_OCH_NEWORDERS_OCH FOREIGN KEY (BOOKID) REFERENCES NEWBOOK_OCH(BOOKID)
);
DESC NEWORDERS_OCH;
DROP TABLE NEWORDERS_OCH;

------------------------------------------

DROP TABLE NEWORDERS_OCH;
DROP TABLE NEWBOOK_OCH;

CREATE TABLE NEWBOOK_OCH
(
    BOOKID NUMBER
    , BOOKNAME VARCHAR2 (20)
    , PUBLISHER VARCHAR2 (20)
    , PRICE NUMBER
);
DESC NEWBOOK_OCH;

-- NewBook ���̺��� VARCHAR2(13)�� �ڷ����� ���� isbn �Ӽ��� �߰��Ͻÿ�
ALTER TABLE NEWBOOK_OCH
ADD ISBN VARCHAR2(13);

DESC NEWBOOK_OCH;

-- NewBook ���̺��� isbn �Ӽ��� ������ Ÿ���� NUMBER������ �����Ͻÿ�
ALTER TABLE NEWBOOK_OCH
MODIFY ISBN NUMBER;
DESC NEWBOOK_OCH;

-- NewBook ���̺��� isbn �Ӽ��� �����Ͻÿ�
ALTER TABLE NEWBOOK_OCH
DROP COLUMN ISBN;
DESC NEWBOOK_OCH;

--  NewBook ���̺��� bookid �Ӽ��� NOT NULL ���������� �����Ͻÿ�
ALTER TABLE NEWBOOK_OCH
MODIFY BOOKID NUMBER NOT NULL;
DESC NEWBOOK_OCH;

-- NewBook ���̺��� bookid �Ӽ��� �⺻Ű�� �����Ͻÿ�
ALTER TABLE NEWBOOK_OCH
ADD PRIMARY KEY (BOOKID);
DESC NEWBOOK_OCH;

-- ���� ���� �� ���� ���̺� ����
DROP TABLE NEWBOOK_OCH;
DROP TABLE NEWCUSTOMER_OCH;