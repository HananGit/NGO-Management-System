package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author rrheg
 */
public class DB4OUtil {

    private static  String FILENAME = "C:\\Users\\sushr\\Desktop\\sushrutt12-aed_fall_2016_project_sushrut_tadwalkar_001647134-ceb6de8afd22\\sushrutt12-aed_fall_2016_project_sushrut_tadwalkar_001647134-ceb6de8afd22\\project version5\\project version5\\updated version\\Database\\DataBank.db4o"; // path to the data store//C:\\DataBank.db4o
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save
//            System.out.println(""+FILENAME);
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

        public synchronized ObjectContainer createConnection(int count) {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            
//                    BufferedReader br = new BufferedReader ( new FileReader ( "dbpath" ));
//        String l = br.readLine();
//        char b=l.charAt(50);
//
//int a=Character.getNumericValue(b);
//a++;
//String z=l.substring(0,50)+a+".db4o";
////        System.out.println(""+l);
////        String b="end";
//
//        BufferedWriter bw = new BufferedWriter(new FileWriter("dbpath"));
//        bw.write(z);
//        bw.close();

            
            
            
            
            
            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save
            String fileName1="C:\\Users\\sushr\\Desktop\\AED Final\\Database\\DataBank"+count+".db4o"; 
            FILENAME=fileName1;
            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
//            db.store(system);
//            db.commit();
//            db.close();
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    public  synchronized void storeSystemBackup(EcoSystem system,int count) {
        ObjectContainer conn = createConnection(count);
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public EcoSystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Change to the object you want to save
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureASystem.configure();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
}
