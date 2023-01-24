CREATE TABLE `tbl_product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_description` varchar(500) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- ---------------------------------------------------------