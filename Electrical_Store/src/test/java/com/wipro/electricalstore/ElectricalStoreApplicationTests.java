package com.wipro.electricalstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.electricalstore.model.City;
import com.wipro.electricalstore.model.Dealer;
import com.wipro.electricalstore.model.Product_category;
import com.wipro.electricalstore.model.Product_table;
import com.wipro.electricalstore.repository.CityRepo;
import com.wipro.electricalstore.repository.DealerRepo;
import com.wipro.electricalstore.repository.ProductCatRepo;
import com.wipro.electricalstore.repository.ProductTableRepo;
import com.wipro.electricalstore.repository.StateRepo;
import com.wipro.electricalstore.service.ElectricalService;
import com.wipro.electricalstore.model.State;



@SpringBootTest
class ElectricalStoreApplicationTests {

	@InjectMocks
    private ElectricalService electricalService;

    @Mock
    private DealerRepo dealerRepo;

    @Mock
    private ProductCatRepo productCatRepo;

    @Mock
    private ProductTableRepo productTableRepo;

    @Mock
    private StateRepo stateRepo;

    @Mock
    private CityRepo cityRepo;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

	@SuppressWarnings("deprecation")
	@Test
    public void testAddProduct() {
        // Create mock data
        Product_table product = new Product_table();
        Dealer dealer = new Dealer();
        Product_category productCategory = new Product_category();

        // Mock repository calls
        when(dealerRepo.getById(any(Integer.class))).thenReturn(dealer);
        when(productCatRepo.getById(any(String.class))).thenReturn(productCategory);
        when(productTableRepo.save(any(Product_table.class))).thenReturn(product);

        // Call the service method
        Product_table result = electricalService.addProduct(product, 1, "category1");

        // Verify the results
        assertEquals(product, result);
    }

    @Test
    public void testRegisterDealer() {
        // Create mock data
        Dealer dealer = new Dealer();

        // Mock repository calls
        when(dealerRepo.save(any(Dealer.class))).thenReturn(dealer);

        // Call the service method
        Dealer result = electricalService.registerDealer(dealer);

        // Verify the results
        assertEquals(dealer, result);
    }

    @Test
    public void testGetDealerByStateAndCity() {
        // Create mock data
        State state = new State();
        City city = new City();
        Dealer dealer = new Dealer();
        List<Dealer> dealerList = new ArrayList<>();
        dealerList.add(dealer);

        // Mock repository calls
        when(stateRepo.findByStateName("StateName")).thenReturn(state);
        when(cityRepo.findByCityName("CityName")).thenReturn(city);
        when(dealerRepo.findByStateAndCity(state, city)).thenReturn(dealerList);

        // Call the service method
        List<Dealer> result = electricalService.getDealerByStateAndCity("StateName", "CityName");

        // Verify the results
        assertEquals(dealerList, result);
    }

    @Test
    public void testGetProductByDealerName() {
        // Create mock data
        Dealer dealer = new Dealer();
        List<Product_table> productTableList = new ArrayList<>();

        // Mock repository calls
        when(dealerRepo.findByDealerName("DealerName")).thenReturn(dealer);
        when(productTableRepo.findByDealer(dealer)).thenReturn(productTableList);

        // Call the service method
        List<Product_table> result = electricalService.getProductByDealerName("DealerName");

        // Verify the results
        assertEquals(productTableList, result);
    }

    @Test
    public void testGetDealerByStateName() {
        // Create mock data
        State state = new State();
        Dealer dealer = new Dealer();
        List<Dealer> dealerList = new ArrayList<>();
        dealerList.add(dealer);

        // Mock repository calls
        when(stateRepo.findByStateName("StateName")).thenReturn(state);
        when(dealerRepo.findByState(state)).thenReturn(dealerList);

        // Call the service method
        List<Dealer> result = electricalService.getDealerByStateName("StateName");

        // Verify the results
        assertEquals(dealerList, result);
    }

	
}
