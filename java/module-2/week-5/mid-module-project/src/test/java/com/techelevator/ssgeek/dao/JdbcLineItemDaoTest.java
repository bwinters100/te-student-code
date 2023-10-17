package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Customer;
import com.techelevator.ssgeek.model.LineItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sound.sampled.Line;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcLineItemDaoTest extends BaseDaoTests {

    private static final LineItem lineOne = new LineItem(1, 1, 1, 1, null, null);

    private JdbcLineItemDao dao;
    @Before
    public void setUp() throws Exception {
        dao = new JdbcLineItemDao(dataSource);
    }
    @Test
    public void getLineItemsBySaleId() {
        List<LineItem> lineItems = dao.getLineItemsBySaleId(1);
        Assert.assertNotNull(lineItems);
        Assert.assertEquals(4, lineItems.size());
    }
}