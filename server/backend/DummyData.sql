--- Users data
 INSERT INTO user_details values
 (1,"123456789123","deep@gmail.com", "deepak","nikhare","9977887788","Ac78778787","pass","Verified","Pauni","abcd","441910","mh","SELLER");
 INSERT INTO user_details values
 (3,"223456789124","deep3@gmail.com", "deepak3","nikhare3","8877887766","BC78778788","pass3","Verified","Pauni","abcd","441910","mh","FARMER");


-- products
INSERT INTO FarmProducts (farm_prod_id, farm_prod_name, farm_prod_type)
VALUES
(1, 'Tomato', 'P'),
(2, 'Apple', 'q'),
(3, 'Lentils', 'Pulse'),
(4, 'Spinach', 'Vegetable'),
(5, 'Banana', 'Fruit'),
(6, 'Chickpeas', 'Pulse'),
(7, 'Carrot', 'Vegetable'),
(8, 'Orange', 'Fruit'),
(9, 'Black-eyed Peas', 'Pulse'),
(10, 'Cabbage', 'Vegetable'),
(11, 'Grapes', 'Fruit'),
(12, 'Green Gram', 'Pulse'),
(13, 'Bell Pepper', 'Vegetable'),
(14, 'Mango', 'Fruit'),
(15, 'Red Lentils', 'Pulse'),
(16, 'Cucumber', 'Vegetable'),
(17, 'Pear', 'Fruit'),
(18, 'Kidney Beans', 'Pulse'),
(19, 'Broccoli', 'Vegetable'),
(20, 'Pineapple', 'Fruit'),
(21, 'Split Peas', 'Pulse'),
(22, 'Zucchini', 'Vegetable'),
(23, 'Watermelon', 'Fruit'),
(24, 'Moong Beans', 'Pulse'),
(25, 'Brussels Sprouts', 'Vegetable'),
(26, 'Papaya', 'Fruit'),
(27, 'Chickpea Flour', 'Pulse'),
(28, 'Eggplant', 'Vegetable'),
(29, 'Kiwi', 'Fruit'),
(30, 'Masoor Dal', 'Pulse'),
(31, 'Asparagus', 'Vegetable'),
(32, 'Strawberry', 'Fruit'),
(33, 'Black Gram', 'Pulse'),
(34, 'Cauliflower', 'Vegetable'),
(35, 'Blueberry', 'Fruit'),
(36, 'Green Peas', 'Pulse'),
(37, 'Bell Pepper', 'Vegetable'),
(38, 'Pomegranate', 'Fruit'),
(39, 'Yellow Lentils', 'Pulse'),
(40, 'Potato', 'Vegetable'),
(41, 'Mango', 'Fruit'),
(42, 'Cowpeas', 'Pulse'),
(43, 'Radish', 'Vegetable'),
(44, 'Peach', 'Fruit'),
(45, 'Black Beans', 'Pulse'),
(46, 'Cabbage', 'Vegetable'),
(47, 'Grapes', 'Fruit'),
(48, 'Chickpeas', 'Pulse'),
(49, 'Spinach', 'Vegetable'),
(50, 'Apple', 'Fruit');


-- Machine
INSERT INTO Machinery (id, machinename, type)
VALUES
(1, 'Tractor', 'Farm Equipment'),
(2, 'Harvester', 'Farm Equipment'),
(3, 'Plow', 'Farm Equipment'),
(4, 'Seeder', 'Farm Equipment'),
(5, 'Cultivator', 'Farm Equipment'),
(6, 'Sprayer', 'Farm Equipment'),
(7, 'Tiller', 'Farm Equipment'),
(8, 'Combine Harvester', 'Farm Equipment'),
(9, 'Irrigation Pump', 'Farm Equipment'),
(10, 'Fertilizer Spreader', 'Farm Equipment'),
(11, 'Baler', 'Farm Equipment'),
(12, 'Mower', 'Farm Equipment'),
(13, 'Drip Irrigation System', 'Irrigation Equipment'),
(14, 'Windrower', 'Farm Equipment'),
(15, 'Rotary Tiller', 'Farm Equipment'),
(16, 'Tractor Seeder', 'Farm Equipment'),
(17, 'Backhoe Loader', 'Construction Equipment'),
(18, 'Front Loader', 'Farm Equipment'),
(19, 'Harrow', 'Farm Equipment'),
(20, 'Manure Spreader', 'Farm Equipment'),
(21, 'Thresher', 'Farm Equipment'),
(22, 'Seeder Drill', 'Farm Equipment'),
(23, 'Cotton Picker', 'Farm Equipment'),
(24, 'Greenhouse Tractor', 'Farm Equipment'),
(25, 'Subsoiler', 'Farm Equipment'),
(26, 'Agricultural Drone', 'Precision Farming Equipment'),
(27, 'Hoe', 'Farm Equipment'),
(28, 'Mulcher', 'Farm Equipment'),
(29, 'Sprinkler System', 'Irrigation Equipment'),
(30, 'Rice Transplanter', 'Farm Equipment'),
(31, 'Plastic Mulch Layer', 'Farm Equipment'),
(32, 'Aerator', 'Farm Equipment'),
(33, 'Seed Drill', 'Farm Equipment'),
(34, 'Chaff Cutter', 'Farm Equipment'),
(35, 'Hydroponic System', 'Precision Farming Equipment'),
(36, 'Post Hole Digger', 'Farm Equipment'),
(37, 'Garden Tractor', 'Farm Equipment'),
(38, 'Fogging Machine', 'Farm Equipment'),
(39, 'Electric Fence', 'Farm Equipment'),
(40, 'Soil Moisture Sensor', 'Precision Farming Equipment'),
(41, 'GPS Guidance System', 'Precision Farming Equipment'),
(42, 'Silage Baler', 'Farm Equipment'),
(43, 'Hedge Trimmer', 'Farm Equipment'),
(44, 'Chisel Plow', 'Farm Equipment'),
(45, 'Cane Harvester', 'Farm Equipment'),
(46, 'Paddy Harvester', 'Farm Equipment'),
(47, 'Farm Truck', 'Transportation Equipment'),
(48, 'Cattle Feed Mixer', 'Farm Equipment'),
(49, 'Farm Trailer', 'Transportation Equipment'),
(50, 'Electric Pruner', 'Farm Equipment');


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
  ('4', 'Apple', 'FRUIT', 'apple.jpg');
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
    ('m4', 'Machine4', 'TYPE3', '/path/to/image4.jpg');
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
    ('4', 'Green Gram', 'PULSES', '/path/to/greengram.jpg');
    ('5', 'Pigeon Peas', 'PULSES', '/path/to/pigeonpeas.jpg'),
    ('6', 'Red Lentils', 'PULSES', '/path/to/redlentils.jpg'),
    ('7', 'Yellow Lentils', 'PULSES', '/path/to/yellowlentils.jpg'),
    ('8', 'Split Bengal Gram', 'PULSES', '/path/to/splitbengalgram.jpg'),
    ('9', 'Kidney Beans', 'PULSES', '/path/to/kidneybeans.jpg'),
    ('10', 'Black-eyed Peas', 'PULSES', '/path/to/blackeyedpeas.jpg');
