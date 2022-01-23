package it.univr.efcgang.mentcare.unit;

import it.univr.efcgang.mentcare.BaseTest;
import it.univr.efcgang.mentcare.models.Drug;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test class of Drug class in model
 * that test all the methods of that class
 */
public class TestDrug extends BaseTest {

    private final Drug drug = new Drug("Drug A");

    @Test
    public void testGetName(){
        assertEquals("Drug A",drug.getName());
    }

}
