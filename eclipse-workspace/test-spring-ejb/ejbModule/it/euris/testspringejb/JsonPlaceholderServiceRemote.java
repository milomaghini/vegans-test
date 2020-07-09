package it.euris.testspringejb;


import java.io.IOException;

import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Remote
@TransactionManagement(TransactionManagementType.CONTAINER)
public interface JsonPlaceholderServiceRemote {
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String getPost(int id) throws IOException;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String getComments(int id) throws IOException;

}
