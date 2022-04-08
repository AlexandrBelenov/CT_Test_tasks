import java.util.LinkedHashMap;
import java.util.Map;

class RecruitmentSolution {
    public static void main(String[] args) {
        final String recordType = "Vacancy";

        Record softwareEngineerVacancy = new Record("SoftwareEngineer0001", recordType);
        Record frontEndEngineerVacancy = new Record("FrontEndEngineer0020", recordType);
        
        /**
         * Implement a logic of actions and invoke those actions below:
         */

        // Invoke "Submit for Approval" for softwareEngineerVacancy
        // Invoke "Approve" for softwareEngineerVacancy

        // Invoke "Submit for Approval" for frontEndEngineerVacancy
        // Invoke "Reject" for frontEndEngineerVacancy
        
        EventListener submitForApproval = new SubmitForApproval();
        EventListener approve = new Approve();
        EventListener reject = new Reject();
        
        IService service = new Service();
        service.subscribe("SubmitForApproval", submitForApproval);
        service.subscribe("Approve", approve);
        service.subscribe("Reject", reject);
        
        service.execute("SubmitForApproval", softwareEngineerVacancy);
        service.execute("Approve", softwareEngineerVacancy);
        service.execute("SubmitForApproval", frontEndEngineerVacancy);
        service.execute("Reject", frontEndEngineerVacancy);
    }

    /**
     * Implement the service below the comment block

    class <Service> {

    }

    */
    interface IService {
    	void subscribe(String eventType, EventListener listener);
    	void unsubscribe(String eventType, EventListener listener);
    	void execute(String eventType, Record record);
    }
    
    static class Service implements IService {
    	private final Map<String, EventListener> events = new LinkedHashMap<String, EventListener>();

		@Override
		public void subscribe(String eventType, EventListener listener) {
			this.events.put(eventType, listener);
		}

		@Override
		public void unsubscribe(String eventType, EventListener listener) {
			this.events.remove(eventType);	
		}
		
		@Override
		public void execute(String eventType, Record record) {
			EventListener listener = this.events.get(eventType);
			listener.execute(record);
		}
    }
    
    static class Record {
        private String id;
        private String type;

        Record(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }
    }
    
    interface EventListener {
    	void execute(Record record);
    }
    
    static class SubmitForApproval implements EventListener {
		@Override
		public void execute(Record record) {
			if ("Vacancy".equals(record.getType())) {
				System.out.println("Submitted for approval Vacancy: " + record.id);
			} 
		}
    }
    
    static class Approve implements EventListener {
		@Override
		public void execute(Record record) {
			if ("Vacancy".equals(record.getType())) {
				System.out.println("Approved Record: " + record.id);
			}
		}	
    }
    
    static class Reject implements EventListener {
		@Override
		public void execute(Record record) {
			if ("Vacancy".equals(record.getType())) {
				System.out.println("Rejected Record: " + record.id);
			}
		}
    }
    
    
}
