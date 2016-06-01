package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import DAO.DbUtil;

public class Inventory {
  private List guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  public void addGuitar(String serialNumber, String price,
                        GuitarSpec spec) {
    Guitar guitar = new Guitar(serialNumber, price, spec);
    guitars.add(guitar);
  }
 
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  public List search(GuitarSpec searchSpec) {
    List matchingGuitars = new LinkedList();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSpec().matches(searchSpec))
        matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }
  
  public boolean loadData() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from inventory where 1=1 ";
		Connection conn=DbUtil.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Inventory inventory=new Inventory();
		while (rs.next()) {
				inventory.addGuitar(rs.getString("serialNumber"),rs.getString("price"), 
					new GuitarSpec(rs.getString("builder"), rs.getString("type"), rs.getString("numStrings"), 
				                     rs.getString("backwood"), rs.getString("topwood")));
					
					}
		ptmt.close();
		return true;
	}
}
