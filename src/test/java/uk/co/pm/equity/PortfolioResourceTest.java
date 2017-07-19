
package uk.co.pm.equity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import uk.co.pm.dao.EQDao;
import uk.co.pm.dao.PortfolioDao;
import uk.co.pm.portfolio.PFReference;
import uk.co.pm.portfolio.PFResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PortfolioResourceTest {


    //This is a Mockito Mock, allowing you to test without using a real DAO
    //See: http://site.mockito.org/
    @Mock
    private PortfolioDao dao;

    private PFResource pfResource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        pfResource = new PFResource(dao);

    }
    /*
     * This tests Portfolio dao object for retreiving all portfolios
     */

    @Test
    public void getEquitiesReturnsTwoEquitiesWhenDaoReturnsTwoEquities() throws Exception {
        List<PFReference> testEquities = Arrays.asList(
                new PFReference(1, "name1", "manager1", 5.0, "currency1"),
                new PFReference(2, "name2", "manager2", 5.0, "currency2"));
        when(dao.getPF()).thenReturn(testEquities);

        //assertThat comes from AssertJ, a great library for writing your tests
        assertThat(pfResource.getallPortfolios())
                .hasSize(2)
                .containsAll(testEquities);
    }
    
    /*
     * This test get specific porfolio based on id
     */
    @Test
    public void getEquitiesForASpecificEpic() throws Exception {
        PFReference testPortfolios = new PFReference(1, "name1", "manager1", 5.0, "currency1");
        when(dao.getSpecificPF(1)).thenReturn(testPortfolios);

        //assertThat comes from AssertJ, a great library for writing your tests
        assertThat(pfResource.getSpecificPF(1))
                .isEqualTo(testPortfolios);
    }
    
    
    
    



}
