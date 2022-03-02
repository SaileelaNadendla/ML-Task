package com.bhavna.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bhavna.Entity.Order;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	@Modifying
	@Query(value= "select * from Orders o inner join Products p on o.Pid = p.Pid inner join Category c on c.Category =p.Category Where c.Category=:Category ", nativeQuery = true)
	public List<Order> getOrderByCategory(String Category);
	
	@Query(value = "select price from  Products  WHERE Pid=:Pid", nativeQuery = true)
	public int getproductPrice(@Param("Pid") int Pid);
	
	@Query(value = "DELETE orders from  Orders o inner join Products p on o.pid = p.pid inner join Category c on c.Category=p.Category  WHERE c.Category=:Category", nativeQuery = true)
	public void deleteByCategory(String Category);
	
	//@Query(value = "UPDATE Orders o join Products p on o.Pid = p.Pid inner join Category c on c.Category =p.Category Where c.Category=:Category ", nativeQuery = true)
	//public void updateOrder(int OrderId , Order order);
	
	
	
	

    
}
