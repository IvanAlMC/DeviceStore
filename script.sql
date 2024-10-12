/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Schema name:    Devices Store                                */
/*==============================================================*/

CREATE DATABASE device_store;

USE device_store;

/*==============================================================*/
/* Table: APPLIANCE_TYPES                                       */
/*==============================================================*/
create table APPLIANCE_TYPES
(
   TYPE_ID              int not null AUTO_INCREMENT,
   SUP_TYPE_ID          int,
   TYPE_NAME            varchar(50) not null,
   TYPE_CHARACTERISTICS varchar(255) not null,
   primary key (TYPE_ID)
);


/*==============================================================*/
/* Table: COMPONENTS                                            */
/*==============================================================*/
create table COMPONENTS
(
   COMPONENT_ID         int not null AUTO_INCREMENT,
   COMPONENT_NAME       varchar(50) not null,
   COMPONENT_SPECS      varchar(200) not null,
   primary key (COMPONENT_ID)
);


/*==============================================================*/
/* Table: COMPONENTS_CHANGE                                     */
/*==============================================================*/
create table COMPONENTS_CHANGE
(
   CHANGE_ID            int not null AUTO_INCREMENT,
   REPAIR_ID            int not null,
   COMPONENT_ID         int not null,
   COMPONENTS_QUANTITY  int not null,
   primary key (CHANGE_ID)
);


/*==============================================================*/
/* Table: CUSTOMERS                                             */
/*==============================================================*/
create table CUSTOMERS
(
   CUSTOMER_ID          int not null AUTO_INCREMENT,
   CUSTOMER_NAME        varchar(20) not null,
   CUSTOMER_CODE_DOCU   varchar(20) not null,
   CUSTOMER_DIRECTION   varchar(200) not null,
   CUSTOMER_PHONE       varchar(15) not null,
   CUSTOMER_EMAIL       varchar(150) not null,
   primary key (CUSTOMER_ID)
);


/*==============================================================*/
/* Table: DETAILS_COMPONENTS                                    */
/*==============================================================*/
create table DETAILS_COMPONENTS
(
   DETAILS_ID           int not null AUTO_INCREMENT,
   COMPONENT_ID         int not null,
   DEVICE_ID            int not null,
   FACTORY_ID           int not null,
   COMPONENT_QUANTITY   int not null,
   COMPONENT_PRICE      int not null,
   primary key (DETAILS_ID)
);


/*==============================================================*/
/* Table: ELECTRONIC_DEVICES                                    */
/*==============================================================*/
create table ELECTRONIC_DEVICES
(
   DEVICE_ID            int not null AUTO_INCREMENT,
   TYPE_ID              int not null,
   DEVICE_NAME          varchar(50) not null,
   DEVICE_DESCRIPTION   varchar(100) not null,
   primary key (DEVICE_ID)
);


/*==============================================================*/
/* Table: MANUFACTURERS                                         */
/*==============================================================*/
create table FACTORIES
(
   FACTORY_ID      int not null AUTO_INCREMENT,
   FACTORY_RIF     varchar(25) not null,
   FACTORY_NAME    varchar(50) not null,
   FACTORY_TAX_DOM varchar(255) not null,
   primary key (FACTORY_ID)
);


/*==============================================================*/
/* Table: REPAIRS                                               */
/*==============================================================*/
create table REPAIRS
(
   REPAIR_ID            int not null AUTO_INCREMENT,
   CUSTOMER_ID          int not null,
   DEVICE_ID            int not null,
   REPAIR_DESCRIPTION   varchar(255) not null,
   REPAIR_DATE          date not null,
   primary key (REPAIR_ID)
);


alter table APPLIANCE_TYPES
      add constraint FK_APTY_FK_IDSPTY foreign key (SUP_TYPE_ID)
            references APPLIANCE_TYPES (TYPE_ID);


alter table COMPONENTS_CHANGE
      add constraint FK_COCH_FK_IDCOM foreign key (COMPONENT_ID)
            references COMPONENTS (COMPONENT_ID);


alter table COMPONENTS_CHANGE
      add constraint FK_COCH_FK_IDREP foreign key (REPAIR_ID)
            references REPAIRS (REPAIR_ID);


alter table DETAILS_COMPONENTS
      add constraint FK_DECO_FK_IDCOM foreign key (COMPONENT_ID)
            references COMPONENTS (COMPONENT_ID);


alter table DETAILS_COMPONENTS
      add constraint FK_DECO_FK_IDDEV foreign key (DEVICE_ID)
            references ELECTRONIC_DEVICES (DEVICE_ID);


alter table DETAILS_COMPONENTS
      add constraint FK_DECO_FK_IDMAFA foreign key (FACTORY_ID)
            references FACTORIES (FACTORY_ID);


alter table ELECTRONIC_DEVICES
      add constraint FK_ELDEV_FK_IDAPTYP foreign key (TYPE_ID)
            references APPLIANCE_TYPES (TYPE_ID);


alter table REPAIRS
      add constraint FK_REPA_FK_IDCUS foreign key (CUSTOMER_ID)
            references CUSTOMERS (CUSTOMER_ID);


alter table REPAIRS
      add constraint FK_REPA_FK_IDDEV foreign key (DEVICE_ID)
            references ELECTRONIC_DEVICES (DEVICE_ID);
