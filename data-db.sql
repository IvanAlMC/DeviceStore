/* Insert data into APPLIANCE_TYPES */
INSERT INTO APPLIANCE_TYPES (SUP_TYPE_ID, TYPE_NAME, TYPE_CHARACTERISTICS)
VALUES 
(NULL, 'Washing Machine', 'Front Load, 7kg Capacity'),
(1, 'Refrigerator', 'Double Door, Frost Free'),
(1, 'Microwave Oven', 'Convection, 30L Capacity'),
(NULL, 'Air Conditioner', 'Split, 1.5 Ton'),
(NULL, 'Television', 'LED, 43 inch, 4K'),
(2, 'Vacuum Cleaner', 'Bagless, 1200W'),
(NULL, 'Dishwasher', '12 Place Settings, Eco Mode'),
(3, 'Water Purifier', 'RO+UV, 7L Capacity'),
(4, 'Electric Kettle', '1.5L, Stainless Steel'),
(NULL, 'Induction Stove', '1800W, Touch Panel');

/* Insert data into COMPONENTS */
INSERT INTO COMPONENTS (COMPONENT_NAME, COMPONENT_SPECS)
VALUES 
('Motor', 'Single Phase, 220V, 1HP'),
('Compressor', 'Rotary, R410A Refrigerant'),
('Heating Element', 'Ceramic, 1000W'),
('Fan Blade', 'Plastic, 16 inch Diameter'),
('LED Panel', 'Full HD, 1920x1080'),
('PCB Board', 'Multi-layer, Microcontroller'),
('Pump', 'Centrifugal, 1/4 HP'),
('Filter', 'Activated Carbon, 10 Micron'),
('Thermostat', 'Digital, 100-240V'),
('Power Cord', '3 pin, 2 meters, 16A');

/* Insert data into COMPONENTS_CHANGE */
INSERT INTO COMPONENTS_CHANGE (REPAIR_ID, COMPONENT_ID, COMPONENTS_QUANTITY)
VALUES 
(1, 1, 2),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(5, 5, 1),
(6, 6, 1),
(7, 7, 1),
(8, 8, 2),
(9, 9, 1),
(10, 10, 3);

/* Insert data into CUSTOMERS */
INSERT INTO CUSTOMERS (CUSTOMER_NAME, CUSTOMER_CODE_DOCU, CUSTOMER_DIRECTION, CUSTOMER_PHONE, CUSTOMER_EMAIL)
VALUES 
('John Doe', 'JD123456', '123 Maple Street, City A', '1234567890', 'john.doe@example.com'),
('Jane Smith', 'JS654321', '456 Oak Avenue, City B', '0987654321', 'jane.smith@example.com'),
('Sam Wilson', 'SW987654', '789 Pine Road, City C', '5678901234', 'sam.wilson@example.com'),
('Lucy Brown', 'LB456789', '321 Birch Lane, City D', '3456789012', 'lucy.brown@example.com'),
('Mark Johnson', 'MJ123789', '654 Cedar Street, City E', '2345678901', 'mark.johnson@example.com'),
('Emily Davis', 'ED567890', '987 Walnut Avenue, City F', '4567890123', 'emily.davis@example.com'),
('Chris Taylor', 'CT789012', '123 Fir Drive, City G', '6789012345', 'chris.taylor@example.com'),
('Natalie Lee', 'NL345678', '456 Spruce Boulevard, City H', '8901234567', 'natalie.lee@example.com'),
('David Martin', 'DM890123', '789 Willow Court, City I', '0123456789', 'david.martin@example.com'),
('Sophie Clark', 'SC234567', '321 Redwood Circle, City J', '6789012345', 'sophie.clark@example.com');

/* Insert data into DETAILS_COMPONENTS */
INSERT INTO DETAILS_COMPONENTS (COMPONENT_ID, DEVICE_ID, FACTORY_ID, COMPONENT_QUANTITY, COMPONENT_PRICE)
VALUES 
(1, 1, 1, 2, 150),
(2, 2, 2, 1, 200),
(3, 3, 3, 1, 100),
(4, 4, 4, 2, 50),
(5, 5, 5, 1, 300),
(6, 6, 6, 1, 120),
(7, 7, 7, 1, 180),
(8, 8, 8, 2, 90),
(9, 9, 9, 1, 70),
(10, 10, 10, 3, 40);

/* Insert data into ELECTRONIC_DEVICES */
INSERT INTO ELECTRONIC_DEVICES (TYPE_ID, DEVICE_NAME, DEVICE_DESCRIPTION)
VALUES 
(1, 'Whirlpool Washer', '7kg, Front Load, Energy Star'),
(2, 'Samsung Fridge', 'Double Door, 345L, Frost Free'),
(3, 'LG Microwave', '30L, Convection, Stainless Steel'),
(4, 'Daikin AC', '1.5 Ton, Split, Inverter'),
(5, 'Sony TV', '43 inch, 4K, LED'),
(6, 'Dyson Vacuum', 'Cordless, Bagless, 1200W'),
(7, 'Bosch Dishwasher', '12 Place, 5 Programs, Silver'),
(8, 'Kent Water Purifier', 'RO+UV, 7L, White'),
(9, 'Philips Electric Kettle', '1.5L, Stainless Steel, Auto Shutoff'),
(10, 'Prestige Induction Stove', '1800W, Touch Panel, Black');

/* Insert data into FACTORIES */
INSERT INTO FACTORIES (FACTORY_RIF, FACTORY_NAME, FACTORY_TAX_DOM)
VALUES 
('RIF123456', 'Whirlpool Corp', '123 Industrial Park, City A'),
('RIF654321', 'Samsung Electronics', '456 Tech Valley, City B'),
('RIF987654', 'LG Appliances', '789 Manufacturing Lane, City C'),
('RIF456789', 'Daikin Industries', '321 Cooling Zone, City D'),
('RIF123789', 'Sony Corporation', '654 Media Street, City E'),
('RIF567890', 'Dyson Ltd', '987 Innovation Drive, City F'),
('RIF789012', 'Bosch GmbH', '123 Eco Road, City G'),
('RIF345678', 'Kent RO Systems', '456 Water Street, City H'),
('RIF890123', 'Philips India', '789 Appliance Lane, City I'),
('RIF234567', 'Prestige Group', '321 Energy Avenue, City J');

/* Insert data into REPAIRS */
INSERT INTO REPAIRS (CUSTOMER_ID, DEVICE_ID, REPAIR_DESCRIPTION, REPAIR_DATE)
VALUES 
(1, 1, 'Motor replacement', '2023-08-01'),
(2, 2, 'Compressor issue fixed', '2023-08-05'),
(3, 3, 'Replaced heating element', '2023-08-10'),
(4, 4, 'Fan blade replaced', '2023-08-12'),
(5, 5, 'LED panel repaired', '2023-08-15'),
(6, 6, 'PCB board short circuit fixed', '2023-08-20'),
(7, 7, 'Pump malfunction fixed', '2023-08-22'),
(8, 8, 'Filter replacement', '2023-08-25'),
(9, 9, 'Thermostat replaced', '2023-08-28'),
(10, 10, 'Power cord replacement', '2023-08-30');
