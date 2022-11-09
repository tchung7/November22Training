use sakila;

select * from city order by city DESC limit 10;

select * from film as f where f.title like '%airplane%';

select MAX(amount) from payment;

select count(*) from customer as c where c.store_id = 1;

select * from payment as p join customer as c on p.customer_id = c.customer_id where c.email = 'NANCY.THOMAS@sakilacustomer.org';

create view bob_fawcett_films as select f.* from film as f join film_actor as fa on fa.film_id = f.film_id join actor as a on a.actor_id = fa.actor_id where a.first_name = 'Bob' and a.last_name = 'Fawcett';

CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAlienCenterInventory`()
begin
	select inventory_id from inventory as i join film as f on i.film_id = f.film_id where f.title = 'Alien Center' and i.store_id = 2;
end

call GetAlienCenterInventory;

start transaction;

set foreign_key_checks = 0;

insert into staff values(3,'Tristan','Chung',5, null, 'tristanchung97@gmail.com', 3,1,'Tristan', null, now());
insert into store values(3,3,3, now());

delete from staff where staff_id = 3;
delete from store where store_id = 3;
set foreign_key_checks = 1;
commit;

select count(*) as '# of movies', rating from film group by rating order by 1 DESC;

select first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id order by 3 desc limit 3;

select distinct(title) from film as f join inventory as i on f.film_id = i.film_id join rental as r on i.inventory_id = r.inventory_id join customer as c on r.customer_id = c.customer_id where r.customer_id = 526 order by 1 asc;

select first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id having sum(amount) > 150 order by 2 asc;