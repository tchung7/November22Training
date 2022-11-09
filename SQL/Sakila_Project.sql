select * from city order by city DESC limit 10;

select * from film as f where f.title like '%airplane%';

select MAX(amount) from payment;

select count(*) from customer as c where c.store_id = 1;

select * from payment as p join customer as c on p.customer_id = c.customer_id where c.email = 'NANCY.THOMAS@sakilacustomer.org';

create view bob_fawcett_films as select f.* from film as f join film_actor as fa on fa.film_id = f.film_id join actor as a on a.actor_id = fa.actor_id where a.first_name = 'Bob' and a.last_name = 'Fawcett';

start transaction;

select @StoreId = MAX(store_id) + 1 from store;
select @StoreAddress = MAX(address_id) + 1 from store;
select @StoreManager = MAX(manager_staff_id) + 1 from store;

insert into staff values(3, 'Tristan', 'Chung', 5, null, 'tristanchung97@gmail.com', references, 1, 'Tristan', null, current_timestamp());
insert into sakila.store(store_id, address_id, manager_staff_id,last_update) values(@StoreId, @StoreAddress, @StoreManager, current_timestamp());

commit;

select count(*), rating from film group by rating;

