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
select p.* from payment as p join customer as c on p.customer_id = c.customer_id where c.email = 'NANCY.THOMAS@sakilacustomer.org';

# Use a view to get the film info for actor Bob Fawcett
set @actorId = (select actor_id from actor where first_name = "Bob" and last_name = "Fawcett");
select film_info from actor_info where actor_id = @actorId;

#Use a stored Procedure to get the 4 inventory ids for the film "Alien Center" at store #2
set @filmId = (select film_id from film as f where f.title = 'Alien Center');

call film_in_stock(@filmId,2, @out_value);

# Create a transaction to insert a new store with a timestamp and then delete that store
start transaction;

insert into staff(first_name, last_name, address_id, email, store_id, active, username) values("Tristan", "Chung", "7", "tristanchung97@gmail.com", "0", "1", "Tristan");

set @staffId = last_insert_id();

insert into address(address, district, city_id, phone, location) values ("3980 Genesee Aven", "La Jolla", 300, 6801117707, ST_GeomFromText('Point(1 1)'));

set @addressId = last_insert_id();

insert into store(manager_staff_id, address_id) values(@staffId, @addressId);

set @storeId = last_insert_id();

update staff set store_id = @storeId where staff_id = @staffId;

rollback;

# Using one SQL statement, get how many films are there in each rating category
select count(*) as '# of movies', rating from film group by rating order by 1 DESC;

# Get (in order) the first and last names of the 3 customers who have spent the most along with how much they have paid overall
select c.customer_id,first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id order by 4 desc limit 1;

# Get all movies rented by the customer who spent the most
set @customer_id = (select karl.customer_id from (select c.customer_id, sum(amount) from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id order by 2 desc limit 1) as karl);
select distinct(title) from film as f join inventory as i on f.film_id = i.film_id join rental as r on i.inventory_id = r.inventory_id join customer as c on r.customer_id = @customer_id order by 1 asc;

# Get the first and last names of all customers who spent more than $150, along with how much they spent
select first_name, last_name, sum(amount) as 'Total Spent' from customer as c join payment as p on p.customer_id = c.customer_id group by c.customer_id having sum(amount) > 150 order by 2 asc;