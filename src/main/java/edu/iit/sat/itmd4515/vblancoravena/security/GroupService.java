 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.security;
import edu.iit.sat.itmd4515.vblancoravena.service.AbstractService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author virginiablancoravena
 */
@Stateless
public class GroupService extends AbstractService<Group>{

    public GroupService() {
        super(Group.class);
    }
    
    
    
    @Override
    public List<Group> findAll(){
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }
    
}
