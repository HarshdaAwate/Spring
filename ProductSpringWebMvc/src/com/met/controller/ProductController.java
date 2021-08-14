package com.met.controller;

	import java.util.Collection;

	//@Component
	@Controller
	@RequestMapping("/product")
	
	public class ProductController {
		
		//private EmployeeService employeeService = new EmployeeService();
		
		@Autowired
		private ProductService productService;
		
		//http://localhost:8055/SpringWebMVC1/mvc/employee
		@GetMapping
		public ModelAndView initializeEmployee(){
			
			ModelAndView modelAndView = new ModelAndView();
			
			Product prd = new Product();
//			prd.setDesignation("FRESHER");
			
			modelAndView.addObject("product", prd);
			
			Collection<Product> allProduct = productService.getAllproduct();
			
			modelAndView.addObject("allProduct", allProduct);
			
			
			modelAndView.setViewName("prdct");
			
			return modelAndView;
			
		}
		
		
		@PostMapping
		public ModelAndView submitProduct(@ModelAttribute Product product){
			ModelAndView modelAndView = new ModelAndView();
			
			System.out.println("From JSP to Product Controller employee object details: " + product);
			
			//write code to save employee object to db
			
			productService.saveProduct(product);
			
			
			Product prd = new Product();
//			prd.setDesignation("FRESHER");
			
			modelAndView.addObject("product", prd);
			
			Collection<Product> allProduct = productService.getAllProduct();
			
			modelAndView.addObject("allProduct", allProduct);
			
			modelAndView.setViewName("prdc");
			
			return modelAndView;
		}
		
		@ExceptionHandler
		public ModelAndView handleException(Exception ex, HttpServletRequest request){
			
			ModelAndView modelAndView = new ModelAndView();
			
			modelAndView.addObject("errMsg", ex.getMessage());
			modelAndView.addObject("url", request.getRequestURI());
			
			modelAndView.setViewName("error");
			
			return modelAndView;
			
		}
		
	}

}
