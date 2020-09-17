insert into skumaster (sku_id,price,sku_name) values (1,50,'A');
insert into skumaster (sku_id,price,sku_name) values (2,30,'B');
insert into skumaster (sku_id,price,sku_name) values (3,20,'C');
insert into skumaster (sku_id,price,sku_name) values (4,10,'D');


insert into promotion_rule (rule_id,created_date,is_active,is_combo_id,is_deleted,price,promotion_name,promotion_rule,
updated_date,sku_id) values(
1,sysdate(),1,0,0,130,'A','3',sysdate(),1
);
insert into promotion_rule (rule_id,created_date,is_active,is_combo_id,is_deleted,price,promotion_name,promotion_rule,
updated_date,sku_id) values(
2,sysdate(),1,0,0,45,'A','2',sysdate(),2
);
insert into promotion_rule (rule_id,created_date,is_active,is_combo_id,is_deleted,price,promotion_name,promotion_rule,
updated_date,sku_id) values(
3,sysdate(),1,1,0,30,'A','4',sysdate(),3
);
insert into promotion_rule (rule_id,created_date,is_active,is_combo_id,is_deleted,price,promotion_name,promotion_rule,
updated_date,sku_id) values(
4,sysdate(),1,1,0,30,'A','3',sysdate(),4
);



--insert into cart_master (cart_id,total_price,updated_date) values (1,100,sysdate());
--insert into cart_master (cart_id,total_price,updated_date) values (2,300,sysdate());
--insert into cart_master (cart_id,total_price,updated_date) values (3,400,sysdate());

