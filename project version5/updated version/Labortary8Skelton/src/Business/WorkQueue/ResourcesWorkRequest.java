/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ResourcesWorkRequest extends WorkRequest {
private ArrayList<Resource> resourceList;
private String title;
private String desc;

    public ResourcesWorkRequest() {
           resourceList=new ArrayList<Resource>();
    }

    
        

    public ArrayList<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(ArrayList<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
   
    @Override
    public String toString()
    {
        return title;
    }
}
