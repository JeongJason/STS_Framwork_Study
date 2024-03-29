package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.Product;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ExampleController {
	// 이름을 입력하고 출근 또는 퇴근 버튼 클릭한다.
	// 출근시간은 9시이며 토근시간은 18시 이다.
	// 출근버튼 클릭시 9시가 넘으면 지각으로 처리,
	// 토근버튼 클릭시 18시 전이라면 토근이 아닌 업무시간으로 처리한다.
	
	// 모든jsp는 work경로 안에 생성하며 아래와 같이 분기별로 jsp문서 한 개씩 작성한다.
	// -getToWork.jsp
	// -leaveWork.jsp
	// -late.jsp
	// -work.jsp
	
	@GetMapping("/checkIn")
	public String checkIn() {
		return "work/checkIn";
	}
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean lateCondition = hour >= 9 && minute > 0;
		if(lateCondition) {
			return "work/late";
		}
		return "work/getToWork";
	}
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		
		boolean leaveWorkCondition = hour >= 18 && minute >= 0;
		if(leaveWorkCondition) {
			return "work/leaveWork";
		}
		return "work/work";
	}
	
	// 상품의 바코드를 입력받고 해당 상품명을 출력한다.
	// 오징어땅콩 - 4383927
	// 초코 우유 - 0832147
	// 벌꿀 피자 - 9841631
	// 샌드위치 - 558757
	
	@GetMapping("/market")
	public String goMarket() {
		return "market/market";
	}
	
	
	@PostMapping("/cashier")
	public String getProduct(String barcode, Model model) {
		String productName = null;
		switch(barcode) {
		case "4383927":
			productName = "오징어땅콩";
			break;
		case "0832147":
			productName = "초코 우유";
			break;
		case "9841631":
			productName = "벌꿀 피자";
			break;
		case "558757":
			productName = "샌드위치";
			break;
		default:
			productName = "없는 상품";
			break;
		}
		
		model.addAttribute("productName", productName);
		return "/market/cashier";
	}
	
	// 선택한 할인률을 해당 상품에 적용
	// 버튼을 여려개 만들어서 클릭된 할인률만큼 상품의 가격 적용
	// @GetMapping("/sale")
	// 메소드명 : goChangeSale
	// saleChange.jsp
	// -선택, 상품명, 가격, 총3개의 항목을 구성한다.
	// - 각 상품의 선택 부분은 radio버튼으로 구성한다.
	// - 버튼은 총 4개의 버튼으로 제작하고, 각각 10% 30% 60% 90%로 구성
	// - 마지막에 적용 버튼을 제작하여 form테그를 전송한다.
	@GetMapping("/sale")
		public String goChangeSale() {
			return "product/saleChange";
		}
	
	
	
	// @PostMapping("change")
	// 메소드명 : change
	// 상품 모델객체로 전체 내용을 전달받는다.
	// 전달받은 상품 가격에 할인률을 적용한 가격을 
	// showChange.jsp로 전달한다.
	@PostMapping("/change")
	public String change(Product product, Model model) {
		log.info(product);
		double rating = (100-product.getDiscountRate())*0.01; 
		model.addAttribute("originPrice", product.getProductPrice());
		product.setProductPrice((int)(product.getProductPrice() * rating));
		return "product/showChange";
	}
	
	@PostMapping("/usePoint")
	public String usePoint(@ModelAttribute("product") Product product) {
		return "product/usePoint";
	}
	
	@PostMapping("/use")
	public String use(Product product, Integer point, Model model) {
		int cash = product.getProductPrice()-point;
		if(point>product.getProductPrice()) {
			point = product.getProductPrice();
			cash = 0;
		}
		
		model.addAttribute("product", product);
		model.addAttribute("point", point);
		model.addAttribute("cash",cash);
		
		return "product/payment";
	}
	
	
	
	
	
	
}
