package jpabook.jpashop.repository.order.simplequery;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
// 성능 최적화된 쿼리용 리파지토리를 별도로 뽑는다
// 얘는 화면에 종속적
// 아무래도 유지보수성이 좋아짐 ~
public class OrderSimpleQueryRepository {

	private final EntityManager em;

	public List<OrderSimpleQueryDto> findOrderDtos(){
		return em.createQuery(
				"select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)" +
				 " from Order o" +
				" join o.member m" +
				" join o.delivery d", OrderSimpleQueryDto.class)
				.getResultList();
	}
}
