use sakila;

# Get 10 cities in descending alphabetical order
select * from city order by city DESC limit 10;

# Get all films with "airplane" in the title
select * from film as f where f.title like '%airplane%';

# Get the highest payment amount
select MAX(amount) as "Highest payment amount" from payment;

# Get the number of records in the customer table for store id # 1
select count(*) from customer as c where c.store_id = 1;

# Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"
select * from payment as p join customer as c on p.customer_id = c.customer_id where c.email = 'NANCY.THOMAS@sakilacustomer.org';

# Use a view to get the film info for actor Bob Fawcett
create view bob_fawcett_films as select f.* from film as f join film_actor as fa on fa.film_id = f.film_id join actor as a on a.actor_id = fa.actor_id where a.first_name = 'Bob' and a.last_name = 'Fawcett';

select film_info from actor_info where actor_id = 19;

#Use a stored Procedure to get the 4 inventory ids for the film "Alien Center" at store #2
call film_in_stock(15,2, @out_value);

# Create a transaction to insert a new store with a timestamp and then delete that store
start transaction;

insert into staff values(3,'Tristan','Chung',5, null, 'tristanchung97@gmail.com', 0,1,'Tristan', null, now());
insert into store values(3,3,3, now());
commit;

delete from store where store_id = 3;

# Using one SQL statement, get how many films are there in each rating category
select count(*) as '# of movies', rating from film group by rating order by 1 DESC;

# Get (in order) the first and last names of the 3 customers who have spent the most along with how much they have paid overall
select first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id order by 3 desc limit 3;

# Get all movies rented by the customer who spent the most
select distinct(title) from film as f join inventory as i on f.film_id = i.film_id join rental as r on i.inventory_id = r.inventory_id join customer as c on r.customer_id = c.customer_id where r.customer_id = 526 order by 1 asc;

# Get the first and last names of all customers who spent more than $150, along with how much they spent
select first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id having sum(amount) > 150 order by 2 asc;