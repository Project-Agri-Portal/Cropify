

-- ---------------------------------- admin table--------------------------------------------

INSERT INTO admin (admin_mobile, admin_email, first_name, root_admin, join_date, last_name, admin_password) VALUES
('1234567890', 'admin1@example.com', 'Aarav', 1, '2022-01-01', 'Patel', 'password123'),
('9876543210', 'admin2@example.com', 'Aditi', 0, '2022-01-02', 'Sharma', 'admin@2022'),
('5556667777', 'admin3@example.com', 'Aryan', 0, '2022-01-03', 'Verma', 'securePassword'),
('9998887777', 'admin4@example.com', 'Avani', 0, '2022-01-04', 'Joshi', 'myAdminPass'),
('7778889999', 'admin5@example.com', 'Dev', 1, '2022-01-05', 'Singh', 'passWord2022'),
('4445556666', 'admin6@example.com', 'Esha', 0, '2022-01-06', 'Kumar', 'secretPass'),
('2223334444', 'admin7@example.com', 'Kabir', 0, '2022-01-07', 'Mishra', 'admin123'),
('6665554444', 'admin8@example.com', 'Ishika', 0, '2022-01-08', 'Gupta', '1234Secure'),
('1112223333', 'admin9@example.com', 'Mihir', 0, '2022-01-09', 'Pandey', 'p@ssw0rd'),
('8887776666', 'admin10@example.com', 'Riya', 1, '2022-01-10', 'Malhotra', 'dummyAdminPass');

-------------------------------- agriculture_products table ------------------------------------

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path) VALUES
('AP001', 'NeemGuard', 'Insecticide', '/images/neemguard.jpg'),
('AP002', 'BioShield', 'Biopesticide', '/images/bioshield.jpg'),
('AP003', 'GreenShield', 'Herbicide', '/images/greenshield.jpg'),
('AP004', 'CropVital', 'Fungicide', '/images/cropvital.jpg'),
('AP005', 'TurmericGuard', 'Insecticide', '/images/turmericguard.jpg'),
('AP006', 'OrganicShield', 'Biopesticide', '/images/organicshield.jpg'),
('AP007', 'LeafSafe', 'Herbicide', '/images/leafsafe.jpg'),
('AP008', 'MintFresh', 'Fungicide', '/images/mintfresh.jpg'),
('AP009', 'RiceProtector', 'Insecticide', '/images/riceprotector.jpg'),
('AP010', 'FruitDefender', 'Biopesticide', '/images/fruitdefender.jpg');

--------------------------------- farm_products table -----------------------------

INSERT INTO farm_products (farm_prod_id, farm_prod_name, farm_prod_type, img_path) VALUES
('f1', 'Rice', 'CROPS', '/images/rice.jpg'),
('f2', 'Apple', 'FRUIT', '/images/apple.jpg'),
('f3', 'Wheat', 'CROPS', '/images/wheat.jpg'),
('f4', 'Ladyfinger', 'VEGETABLE', '/images/ladyfinger.jpg'),
('f5', 'Mango', 'FRUIT', '/images/mango.jpg'),
('f6', 'Carrot', 'VEGETABLE', '/images/carrot.jpg'),
('f7', 'Potato', 'VEGETABLE', '/images/potato.jpg'),
('f8', 'Papaya', 'FRUIT', '/images/papaya.jpg'),
('f9', 'Maize', 'CROPS', '/images/maize.jpg'),
('f10', 'Sugarcane', 'CROPS', '/images/sugarcane.jpg');

--------------------------------- machinery table -----------------------------------

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type) VALUES
('m1', '/images/tractor.jpg', 'Kisan King Tractor', 'TRACTOR'),
('m2', '/images/plough.jpg', 'Harit Kranti Plough', 'PLOUGH'),
('m3', '/images/harvester.jpg', 'Krishi Sampada Harvester', 'HARVESTOR'),
('m4', '/images/seeder.jpg', 'Beej Boy Seeder', 'SEEDER'),
('m5', '/images/irrigation_pump.jpg', 'Jal Shakti Pump', 'IRRIGATION_PUMP'),
('m6', '/images/crop_sprayer.jpg', 'Swasthya Khet Crop Sprayer', 'CROP_SPRAYER'),
('m7', '/images/tiller.jpg', 'Krishi Sathi Tiller', 'TILLER'),
('m8', '/images/thresher.jpg', 'Annapurna Thresher', 'THRESHER'),
('m9', '/images/cultivator.jpg', 'Utkarsh Krishi Cultivator', 'CULTIVATOR'),
('m10', '/images/seed_drill.jpg', 'Beej Express Seed Drill', 'SEED_DRILL');


---------------------------------------- user_details table -----------------------------------

INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type) VALUES
('112233445566', 'amit.verma@example.com', 'Amit', 'Verma', '9876543211', 'ABCD123456', 'hashed_password', 'Active', 'Jaipur', '456, XYZ Street, ABC Colony', '302001', 'Rajasthan', 'FARMER'),
('223344556677', 'poonam.gupta@example.com', 'Poonam', 'Gupta', '8765432101', 'PQRS567890', 'hashed_password', 'Active', 'Lucknow', '789, LMN Street, PQR Colony', '226001', 'Uttar Pradesh', 'SELLER'),
('334455667788', 'mohan.sharma@example.com', 'Mohan', 'Sharma', '7654321090', 'WXYZ123456', 'hashed_password', 'Active', 'Hyderabad', '101, UVW Street, LMN Colony', '500001', 'Telangana', 'CUSTOMER'),
('445566778899', 'neha.yadav@example.com', 'Neha', 'Yadav', '6543210981', 'LMNO567890', 'hashed_password', 'Inactive', 'Ahmedabad', '202, PQR Street, WXY Colony', '380001', 'Gujarat', 'FARMER'),
('556677889900', 'raj.mishra@example.com', 'Raj', 'Mishra', '5432109872', 'UVWX123456', 'hashed_password', 'Active', 'Chandigarh', '303, ABC Street, XYZ Colony', '160001', 'Punjab', 'SELLER'),
('667788990011', 'ananya.singh@example.com', 'Ananya', 'Singh', '4321098765', 'PQRS123456', 'hashed_password', 'Active', 'Bhopal', '505, WXY Street, UVW Colony', '462001', 'Madhya Pradesh', 'SELLER');

-- Agriculture product
INSERT INTO AgricultureProducts (id, agriproductname, type)
VALUES
(1, 'Basmati Rice Seeds', 'Seeds'),
(2, 'Bajra Seeds', 'Seeds'),
(3, 'Okra Seeds', 'Seeds'),
(4, 'Mustard Seeds', 'Seeds'),
(5, 'Brinjal Seeds', 'Seeds'),
(6, 'Cotton Hybrid Seeds', 'Seeds'),
(7, 'Rice Paddy Seeds', 'Seeds'),
(8, 'Wheat Seeds', 'Seeds'),
(9, 'Potato Seeds', 'Seeds'),
(10, 'Carrot Seeds', 'Seeds'),
(11, 'Sunflower Hybrid Seeds', 'Seeds'),
(12, 'Red Onion Seeds', 'Seeds'),
(13, 'Neem-based Pesticide', 'Pesticides'),
(14, 'Pyrethroid Insecticide', 'Pesticides'),
(15, 'Biopesticide', 'Pesticides'),
(16, 'Bioinsecticide', 'Pesticides'),
(17, 'Copper Oxychloride Fungicide', 'Pesticides'),
(18, 'Organic Pesticide Spray', 'Pesticides'),
(19, 'Neem Oil Extract', 'Pesticides'),
(20, 'Organic Nitrogen Fertilizer', 'Fertilizers'),
(21, 'Phosphate-rich Fertilizer', 'Fertilizers'),
(22, 'Potash-based Fertilizer', 'Fertilizers'),
(23, 'NPK Compound Fertilizer', 'Fertilizers'),
(24, 'Organic Manure', 'Fertilizers'),
(25, 'Vermicompost', 'Fertilizers'),
(26, 'Slow-Release Organic Fertilizer', 'Fertilizers'),
(27, 'Liquid Seaweed Fertilizer', 'Fertilizers'),
(28, 'Granular Urea Fertilizer', 'Fertilizers'),
(29, 'Ammonium Sulfate Fertilizer', 'Fertilizers'),
(30, 'Superphosphate Fertilizer', 'Fertilizers'),
(31, 'Compost Mix', 'Fertilizers'),
(32, 'Cow Manure Pellets', 'Fertilizers'),
(33, 'Sorghum Seeds', 'Seeds'),
(34, 'Mango Seeds', 'Seeds'),
(35, 'Chickpea Seeds', 'Seeds'),
(36, 'Coriander Seeds', 'Seeds'),
(37, 'Papaya Seeds', 'Seeds'),
(38, 'Cumin Seeds', 'Seeds'),
(39, 'Marigold Flower Seeds', 'Seeds'),
(40, 'Fenugreek Seeds', 'Seeds'),
(41, 'Organic Pesticide Powder', 'Pesticides'),
(42, 'Bioinsecticide Spray', 'Pesticides'),
(43, 'Herbal Insect Repellent', 'Pesticides'),
(44, 'Copper-based Fungicide', 'Pesticides'),
(45, 'Sulphur Dust', 'Pesticides'),
(46, 'Organic Neem Oil', 'Pesticides'),
(47, 'Rock Phosphate Fertilizer', 'Fertilizers'),
(48, 'Fish Meal Fertilizer', 'Fertilizers'),
(49, 'Bone Meal Fertilizer', 'Fertilizers'),
(50, 'Green Manure Mix', 'Fertilizers');

-- ------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO  user_details (first_name, last_name, email, password, mobile_no, user_type, full_address, city, state, pincode, aadhar_no, pan_no, status)
VALUES
('Amit', 'Sharma', 'amit.sharma@example.com', 'hashedPassword', '9876543210', 'ADMIN', '102 Ganga Nagar', 'Delhi', 'Delhi', '110001', '123456789012', 'ABCDE1234F', 'ACTIVE'),
('Priya', 'Patel', 'priya.patel@example.com', 'hashedPassword', '8765432109', 'SELLER', '205 Tulsi Vihar', 'Mumbai', 'Maharashtra', '400001', '987654321098', 'FGHIJ5678K', 'ACTIVE'),
('Raj', 'Verma', 'raj.verma@example.com', 'hashedPassword', '7654321098', 'CUSTOMER', '308 Yamuna Enclave', 'Jaipur', 'Rajasthan', '302001', '234567890123', 'LMNOP6789Q', 'INACTIVE'),
('Sneha', 'Singh', 'sneha.singh@example.com', 'hashedPassword', '6543210987', 'CUSROMER', '401 Rose Lane', 'Bangalore', 'Karnataka', '560001', '345678901234', 'QRSTU9012V', 'ACTIVE');
('Vijay', 'Kumar', 'vijay.kumar@example.com', 'hashedPassword', '5432109876', 'CUSTOMER', '504 Jasmine Road', 'Chennai', 'Tamil Nadu', '600001', '456789012345', 'BCDEA3456C', 'ACTIVE'),
('Pooja', 'Gupta', 'pooja.gupta@example.com', 'hashedPassword', '4321098765', 'SELLER', '607 Orchid Street', 'Kolkata', 'West Bengal', '700001', '567890123456', 'LMNOP5678Q', 'ACTIVE'),
('Rahul', 'Sinha', 'rahul.sinha@example.com', 'hashedPassword', '3210987654', 'FARMER', '710 Lotus Lane', 'Hyderabad', 'Telangana', '500001', '678901234567', 'QRSTU6789V', 'ACTIVE'),
('Anita', 'Mishra', 'anita.mishra@example.com', 'hashedPassword', '2109876543', 'SELLER', '813 Sunflower Road', 'Ahmedabad', 'Gujarat', '380001', '789012345678', 'FGHIJ4567K', 'ACTIVE'),
('Arun', 'Reddy', 'arun.reddy@example.com', 'hashedPassword', '1098765432', 'FARMER', '906 Marigold Avenue', 'Pune', 'Maharashtra', '411001', '890123456789', 'WXYZA2345B', 'ACTIVE'),
('Smita', 'Joshi', 'smita.joshi@example.com', 'hashedPassword', '9876543210', 'SELLER', '1001 Daisy Drive', 'Lucknow', 'Uttar Pradesh', '226001', '987654321098', 'FGHIJ5678K', 'INACTIVE'),
('Rajat', 'Malhotra', 'rajat.malhotra@example.com', 'hashedPassword', '8765432109', 'CUSTOMER', '1104 Lily Lane', 'Chandigarh', 'Punjab', '160001', '234567890123', 'LMNOP6789Q', 'ACTIVE'),
('Neha', 'Rastogi', 'neha.rastogi@example.com', 'hashedPassword', '7654321098', 'FARMER', '1207 Jasmine Road', 'Bhopal', 'Madhya Pradesh', '462001', '345678901234', 'QRSTU9012V', 'ACTIVE'),
('Ravi', 'Yadav', 'ravi.yadav@example.com', 'hashedPassword', '6543210987', 'CUSTOMER', '1309 Orchid Street', 'Nagpur', 'Maharashtra', '440001', '456789012345', 'BCDEA3456C', 'ACTIVE'),
('Anjali', 'Chopra', 'anjali.chopra@example.com', 'hashedPassword', '5432109876', 'FARMER', '1412 Lotus Lane', 'Indore', 'Madhya Pradesh', '452001', '567890123456', 'LMNOP5678Q', 'ACTIVE'),
('Prateek', 'Gandhi', 'prateek.gandhi@example.com', 'hashedPassword', '4321098765', 'CUSTOMER', '1505 Sunflower Road', 'Vadodara', 'Gujarat', '390001', '678901234567', 'QRSTU6789V', 'ACTIVE');


-- Farm Product 1
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1001, 'Organic Wheat Flour', 'GRAIN', '/images/wheat_flour.jpg');

-- Farm Product 2
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1002, 'Fresh Apples', 'FRUIT', '/images/apples.jpg');

-- Farm Product 3
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1003, 'Green Tea Leaves', 'BEVERAGE', '/images/green_tea_leaves.jpg');

-- Farm Product 4
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1004, 'Organic Tomatoes', 'VEGETABLE', '/images/organic_tomatoes.jpg');

-- Farm Product 5
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1005, 'Spicy Curry Mix', 'SPICE', '/images/curry_mix.jpg');

-- Farm Product 6
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1006, 'Lentils (Masoor Dal)', 'PULSE', '/images/masoor_dal.jpg');

-- Farm Product 7
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1007, 'Fresh Oranges', 'FRUIT', '/images/oranges.jpg');

-- Farm Product 8
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1008, 'Cinnamon Sticks', 'SPICE', '/images/cinnamon_sticks.jpg');

-- Farm Product 9
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1009, 'Organic Spinach', 'VEGETABLE', '/images/organic_spinach.jpg');

-- Farm Product 10
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type, imgPath)
VALUES (1010, 'Coffee Beans', 'BEVERAGE', '/images/coffee_beans.jpg');


-- Inserting 10 dummy records into the AgricultureProducts table
INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_Path)
VALUES
  ('1', 'Wheat', 'CROP', 'wheat.jpg'),
  ('2', 'Corn', 'CROP', 'corn.jpg'),
  ('3', 'Tomato', 'VEGETABLE', 'tomato.jpg'),
  ('4', 'Apple', 'FRUIT', 'apple.jpg'),
  ('5', 'Potato', 'VEGETABLE', 'potato.jpg'),
  ('6', 'Orange', 'FRUIT', 'orange.jpg'),
  ('7', 'Rice', 'CROP', 'rice.jpg'),
  ('8', 'Carrot', 'VEGETABLE', 'carrot.jpg'),
  ('9', 'Grapes', 'FRUIT', 'grapes.jpg'),
  ('10', 'Barley', 'CROP', 'barley.jpg');


INSERT INTO Machinery (machine_id, machine_name, machine_type, img_path)
VALUES
    ('m1', 'Machine1', 'TYPE1', '/path/to/image1.jpg'),
    ('m2', 'Machine2', 'TYPE2', '/path/to/image2.jpg'),
    ('m3', 'Machine3', 'TYPE1', '/path/to/image3.jpg'),
    ('m4', 'Machine4', 'TYPE3', '/path/to/image4.jpg'),
    ('m5', 'Machine5', 'TYPE2', '/path/to/image5.jpg'),
    ('m6', 'Machine6', 'TYPE1', '/path/to/image6.jpg'),
    ('m7', 'Machine7', 'TYPE3', '/path/to/image7.jpg'),
    ('m8', 'Machine8', 'TYPE2', '/path/to/image8.jpg'),
    ('m9', 'Machine9', 'TYPE1', '/path/to/image9.jpg'),
    ('m10', 'Machine10', 'TYPE3', '/path/to/image10.jpg');


INSERT INTO farm_products (farm_prod_id, farm_prod_name, farm_prod_type,  img_path)
VALUES
    ('1', 'Lentils', 'PULSES', '/path/to/lentils.jpg'),
    ('2', 'Chickpeas', 'PULSES', '/path/to/chickpeas.jpg'),
    ('3', 'Black Gram', 'PULSES', '/path/to/blackgram.jpg'),
    ('4', 'Green Gram', 'PULSES', '/path/to/greengram.jpg'),
    ('5', 'Pigeon Peas', 'PULSES', '/path/to/pigeonpeas.jpg'),
    ('6', 'Red Lentils', 'PULSES', '/path/to/redlentils.jpg'),
    ('7', 'Yellow Lentils', 'PULSES', '/path/to/yellowlentils.jpg'),
    ('8', 'Split Bengal Gram', 'PULSES', '/path/to/splitbengalgram.jpg'),
    ('9', 'Kidney Beans', 'PULSES', '/path/to/kidneybeans.jpg'),
    ('10', 'Black-eyed Peas', 'PULSES', '/path/to/blackeyedpeas.jpg');



-- ------------------------------------------------
-- final
-- ---------------------------------
    -- Insert fruits data
INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Apple', 'FRUIT', 'http://localhost:3000/static/media/apple-1834639_1280.681aafd5ece88c5a242a.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Banana', 'FRUIT', 'http://localhost:3000/static/media/banana-1504956_1280.a7ad278afdcc7a73da93.png');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Orange', 'FRUIT', 'http://localhost:3000/static/media/orange.6d3082675e43880374c7.png');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Grapes', 'FRUIT', 'http://localhost:3000/static/media/vines-1747224_1280.d336d6bb00fdb086e521.jpg');

-- Insert vegetables data
INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Carrot', 'VEGETABLE', 'http://localhost:3000/static/media/product-7.b174025881dfbb6ef585.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Spinach', 'VEGETABLE', 'http://localhost:3000/static/media/vegetables-7413568_1280.da9b5b5d90f440f4a29d.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Tomato', 'VEGETABLE', 'http://localhost:3000/static/media/product-5.5a5380de12781f487246.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Cucumber', 'VEGETABLE', 'http://localhost:3000/static/media/cucumbers-1799262_1280.7a34679ae961c188f3b2.jpg');

-- Insert pulses data
INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Lentils', 'PULSES', 'http://localhost:3000/static/media/lentils-628468_1280.bc7ee5b70cdd3cb86b73.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Chickpeas', 'PULSES', 'http://localhost:3000/static/media/chickpeas-3663027_1280.03386c03ae0b267103ef.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Black Beans', 'PULSES', 'http://localhost:3000/static/media/coffee-6796427_1280.72f7d9e497512349a6c7.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Green Peas', 'PULSES', 'http://localhost:3000/static/media/pea-1205679_1280.d33a6a3a99a97f22b3d2.jpg');

-- Insert more data
INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Pineapple', 'FRUIT', 'http://localhost:3000/static/media/pineapple-5108775_1280.3d2effb69a08e30909e5.jpg');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Broccoli', 'VEGETABLE', 'c:\Users\Win 10 Pc\Downloads\broccoli-1450274_1280.png');

INSERT INTO farm_products (farm_prod_name, farm_prod_type, img_path)
VALUES ('Kidney Beans', 'PULSES', 'http://localhost:3000/static/media/red-2313107_1280.3abe9c79cd27ae7ed4f3.jpg');


-- -----------------------------------------------------------
-- Insert machinery data
INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (1, '/images/tractor.jpg', 'John Deere Tractor', 'TRACTOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (2, '/images/plough.jpg', 'Heavy Duty Plough', 'PLOUGH');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (3, '/images/harvestor.jpg', 'Combine Harvestor', 'HARVESTOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (4, '/images/seeder.jpg', 'Precision Seeder', 'SEEDER');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (5, '/images/irrigation_pump.jpg', 'High-Flow Irrigation Pump', 'IRRIGATION_PUMP');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (6, '/images/crop_sprayer.jpg', 'Automatic Crop Sprayer', 'CROP_SPRAYER');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (7, '/images/tiller.jpg', 'Rotary Tiller', 'TILLER');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (8, '/images/thresher.jpg', 'Grain Thresher', 'THRESHER');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (9, '/images/cultivator.jpg', 'Disc Cultivator', 'CULTIVATOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (10, '/images/seed_drill.jpg', 'Precision Seed Drill', 'SEED_DRILL');

-- Add more machinery data
INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (11, '/images/tractor2.jpg', 'Massey Ferguson Tractor', 'TRACTOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (12, '/images/harvestor2.jpg', 'New Holland Combine Harvestor', 'HARVESTOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (13, '/images/cultivator2.jpg', 'Spring Tine Cultivator', 'CULTIVATOR');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (14, '/images/tiller2.jpg', 'Power Tiller', 'TILLER');

INSERT INTO machinery (machine_id, img_path, machine_name, machine_type)
VALUES (15, '/images/seeder2.jpg', 'Air Seeder', 'SEEDER');

-- ---------------------------------------------------
-- Insert agriculture products data
INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (1, 'InsectAway', 'PESTICIDE', '/images/insect_away.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (2, 'BioGrowth', 'FERTILIZER', '/images/bio_growth.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (3, 'WeedGuard', 'PESTICIDE', '/images/weed_guard.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (4, 'NutriBoost', 'FERTILIZER', '/images/nutri_boost.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (5, 'BugShield', 'PESTICIDE', '/images/bug_shield.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (6, 'GreenGro', 'FERTILIZER', '/images/green_gro.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (7, 'MightyGrow', 'FERTILIZER', '/images/mighty_grow.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (8, 'PestMaster', 'PESTICIDE', '/images/pest_master.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (9, 'OrganicBlend', 'FERTILIZER', '/images/organic_blend.jpg');

INSERT INTO agriculture_products (agri_prod_id, agri_prod_name, agri_prod_type, img_path)
VALUES (10, 'SafeGuard', 'PESTICIDE', '/images/safe_guard.jpg');

-- ----------------------------------------------------------

-- Insert user details data with Indian names
-- Insert user details data with Indian names (modified)
INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type, img_path)
VALUES 
('123456789012', 'aarav.kumar@example.com', 'Aarav', 'Kumar', '9876543210', 'ABCDE1234F', 'hashedpassword', 'ACTIVE', 'Delhi', '123, Main Street', '110001', 'Delhi', 'CUSTOMER', '/images/customer1.jpg'),

('987654321098', 'ananya.singh@example.com', 'Ananya', 'Singh', '8765432109', 'XYZW3210P', 'hashedpassword', 'ACTIVE', 'Mumbai', '456, Garden Street', '400001', 'Maharashtra', 'FARMER', '/images/farmer2.jpg'),

('654321098765', 'amit.patel@example.com', 'Amit', 'Patel', '7654321098', 'PQRS5678H', 'hashedpassword', 'ACTIVE', 'Ahmedabad', '789, Market Street', '380001', 'Gujarat', 'SELLER', '/images/seller3.jpg'),

('321098765432', 'aditi.sharma@example.com', 'Aditi', 'Sharma', '6543210987', 'MNOB1234Z', 'hashedpassword', 'ACTIVE', 'Jaipur', '101, Palace Road', '302001', 'Rajasthan', 'ADMIN', '/images/admin4.jpg');

-- Insert user details data with Indian names (modified, continued)
INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type, img_path)
VALUES 
('987654321011', 'divya.agarwal@example.com', 'Divya', 'Agarwal', '8765432101', 'WXYZ1234G', 'hashedpassword', 'ACTIVE', 'Hyderabad', '102, Hill Street', '500001', 'Telangana', 'CUSTOMER', '/images/customer51.jpg'),

('654321098762', 'rajat.srivastava@example.com', 'Rajat', 'Srivastava', '7654321098', 'MNOP5678J', 'hashedpassword', 'ACTIVE', 'Patna', '703, River Lane', '800001', 'Bihar', 'FARMER', '/images/farmer52.jpg'),

('321098765413', 'piyush.goyal@example.com', 'Piyush', 'Goyal', '6543210983', 'RSTU4321L', 'hashedpassword', 'ACTIVE', 'Chandigarh', '201, Sky Street', '160001', 'Punjab', 'SELLER', '/images/seller53.jpg'),

('654321098764', 'radhika.verma@example.com', 'Radhika', 'Verma', '8767432109', 'LMNO4321M', 'hashedpassword', 'ACTIVE', 'Bhopal', '405, Valley Road', '462001', 'Madhya Pradesh', 'ADMIN', '/images/admin54.jpg');

-- Insert user details data with Indian names (modified, continued)
INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type, img_path)
VALUES 
('487654321012', 'neha.gupta@example.com', 'Neha', 'Gupta', '8465432101', 'GHIJ1234K', 'hashedpassword', 'ACTIVE', 'Jaipur', '302, Sunshine Avenue', '302001', 'Rajasthan', 'CUSTOMER', '/images/customer101.jpg'),

('754321098765', 'anand.shukla@example.com', 'Anand', 'Shukla', '7656321098', 'QRST5678L', 'hashedpassword', 'ACTIVE', 'Kolkata', '502, Green Gardens', '700001', 'West Bengal', 'FARMER', '/images/farmer102.jpg'),

('324098765432', 'rashmi.yadav@example.com', 'Rashmi', 'Yadav', '6543210917', 'UVWX4321M', 'hashedpassword', 'ACTIVE', 'Lucknow', '102, Star Street', '226001', 'Uttar Pradesh', 'SELLER', '/images/seller103.jpg'),

('654301098765', 'arjun.mishra@example.com', 'Arjun', 'Mishra', '8765432106', 'WXYZ4321N', 'hashedpassword', 'ACTIVE', 'Delhi', '405, Moon Lane', '110001', 'Delhi NCR', 'ADMIN', '/images/admin104.jpg');

-- Insert user details data with Indian names (modified, continued)
INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type, img_path)
VALUES 
('654321098760', 'shivani.patel@example.com', 'Shivani', 'Patel', '8765432105', 'LMNOKP', 'hashedpassword', 'ACTIVE', 'Mumbai', '304, Beach Street', '400002', 'Maharashtra', 'CUSTOMER', '/images/customer105.jpg'),

('321098765431', 'rohan.kumar@example.com', 'Rohan', 'Kumar', '7654321099', 'MNOBDE', 'hashedpassword', 'ACTIVE', 'Delhi', '501, Main Boulevard', '110002', 'Delhi NCR', 'FARMER', '/images/farmer106.jpg'),

('987654321015', 'tanvi.gupta@example.com', 'Tanvi', 'Gupta', '6543210982', 'GHIJKL', 'hashedpassword', 'ACTIVE', 'Bangalore', '202, Tech Lane', '560002', 'Karnataka', 'SELLER', '/images/seller107.jpg'),

('654321098761', 'rohit.sharma@example.com', 'Rohit', 'Sharma', '8765432108', 'STUVWX', 'hashedpassword', 'ACTIVE', 'Chennai', '601, Garden Road', '600002', 'Tamil Nadu', 'ADMIN', '/images/admin108.jpg'),

('321098765418', 'tanya.mishra@example.com', 'Tanya', 'Mishra', '6543210981', 'RSTUVW', 'hashedpassword', 'ACTIVE', 'Hyderabad', '405, Hill View', '500002', 'Telangana', 'CUSTOMER', '/images/customer109.jpg'),

('654311098761', 'surya.yadav@example.com', 'Surya', 'Yadav', '8795432104', 'XYZABC', 'hashedpassword', 'ACTIVE', 'Lucknow', '203, Sky View', '226002', 'Uttar Pradesh', 'FARMER', '/images/farmer110.jpg'),

('321098765435', 'piya.choudhary@example.com', 'Piya', 'Choudhary', '6543210980', 'UVWXYZ', 'hashedpassword', 'ACTIVE', 'Jaipur', '303, Market Lane', '302002', 'Rajasthan', 'SELLER', '/images/seller111.jpg'),;


-- Insert new user details data with Indian names and email in the name
INSERT INTO user_details (aadhar_no, email, first_name, last_name, mobile_no, pan_no, password, status, city, full_address, pincode, state, user_type, img_path)
VALUES 
('111122223333', 'amitabh.kumar@example.com', 'Amitabh', 'Kumar', '9876143210', 'ABCDE1234G', 'hashedpassword', 'ACTIVE', 'Delhi', '456, New Street', '110002', 'Delhi', 'CUSTOMER', '/images/newuser1.jpg'),

('444455556666', 'deepika.singh@example.com', 'Deepika', 'Singh', '8765482109', 'XYZW3210Q', 'hashedpassword', 'ACTIVE', 'Mumbai', '789, Fresh Street', '400002', 'Maharashtra', 'FARMER', '/images/newuser2.jpg'),

('777788889999', 'rajesh.patel@example.com', 'Rajesh', 'Patel', '1654321098', 'PQRS5678I', 'hashedpassword', 'ACTIVE', 'Ahmedabad', '101, Modern Road', '380002', 'Gujarat', 'SELLER', '/images/newuser3.jpg'),

('999988877777', 'sunita.sharma@example.com', 'Sunita', 'Sharma', '6743210987', 'MNOB1234Y', 'hashedpassword', 'ACTIVE', 'Lucknow', '202, Innovate Street', '226003', 'Uttar Pradesh', 'ADMIN', '/images/newuser4.jpg');
