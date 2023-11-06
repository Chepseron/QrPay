/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author PROBOOK
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Bean.service.AccountsFacadeREST.class);
        resources.add(Bean.service.AudittrailFacadeREST.class);
        resources.add(Bean.service.BanksFacadeREST.class);
        resources.add(Bean.service.IdentificationtypesFacadeREST.class);
        resources.add(Bean.service.NationalityFacadeREST.class);
        resources.add(Bean.service.QrcodedetailsFacadeREST.class);
        resources.add(Bean.service.RolesFacadeREST.class);
        resources.add(Bean.service.TransactionchargesFacadeREST.class);
        resources.add(Bean.service.TransactionsFacadeREST.class);
        resources.add(Bean.service.TransactiontypesFacadeREST.class);
        resources.add(Bean.service.UserrolesFacadeREST.class);
        resources.add(Bean.service.UsersFacadeREST.class);
    }
    
}
