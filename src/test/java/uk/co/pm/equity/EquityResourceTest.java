package uk.co.pm.equity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import uk.co.pm.dao.EQDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class EquityResourceTest {


    //This is a Mockito Mock, allowing you to test without using a real DAO
    //See: http://site.mockito.org/
    @Mock
    private EQDao dao;

    private EQResource eqResource;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        eqResource = new EQResource(dao);

    }
    /*
     * This tests Equity dao object for retreiving all equities
     */

    @Test
    public void getEquitiesReturnsFourEquitiesWhenDaoReturnsTwoEquities() throws Exception {
        List<EQReference> testEquities = Arrays.asList(
                new EQReference("epic1","companyname1","assettype1","sector1","currency1","datetime1", new Float(2.0)),
                new EQReference("epic2","companyname2","assettype2","sector2","currency2","datetime2", new Float(2.0)),
        		new EQReference("epic3","companyname3","assettype3","sector3","currency3","datetime3", new Float(2.0)),
                new EQReference("epic4","companyname4","assettype4","sector4","currency4","datetime4", new Float(2.0)));
        when(dao.getEQ()).thenReturn(testEquities);

        //assertThat comes from AssertJ, a great library for writing your tests
        assertThat(eqResource.getallEquities())
                .hasSize(4)
                .containsAll(testEquities);
    }
    
    /*
     * This test get specific equity based on epic
     */
    @Test
    public void getEquitiesForASpecificEpic() throws Exception {
        List<EQReference> testEquities = Arrays.asList(
                new EQReference("epic1","companyname1","assettype1","sector1","currency1","datetime1", new Float(2.0)),
                new EQReference("epic2","companyname2","assettype2","sector2","currency2","datetime2", new Float(2.0)),
        		new EQReference("epic3","companyname3","assettype3","sector3","currency3","datetime3", new Float(2.0)),
                new EQReference("epic4","companyname4","assettype4","sector4","currency4","datetime4", new Float(2.0)));
        when(dao.getSpecificEQ("epic1")).thenReturn(testEquities);

        //assertThat comes from AssertJ, a great library for writing your tests
        assertThat(eqResource.getSpecificEQ("epic1"))
                .contains(testEquities.get(0));
    }
    
    
    
    



}
