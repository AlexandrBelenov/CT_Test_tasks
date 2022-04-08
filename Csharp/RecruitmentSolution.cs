using System;
using System.Collections.Generic;
using System.Collections;

namespace recruitment
{
    class RecruitmentSolution {
        static void Main(String[] args) {
            String RecordType = "Vacancy";

            Record softwareEngineerVacancy = new Record("SoftwareEngineer0001", RecordType);
            Record frontEndEngineerVacancy = new Record("FrontEndEngineer0020", RecordType);
            var submitForApproval = new SubmitForApproval();
            var approve = new Approve();
            var reject = new Reject();
            var service = new Service();
            service.Subscribe("SubmitForApproval", submitForApproval);
            service.Subscribe("Approve", approve);
            service.Subscribe("Reject", reject);
            service.Execute("SubmitForApproval", softwareEngineerVacancy);
            service.Execute("Approve", softwareEngineerVacancy);
            service.Execute("SubmitForApproval", frontEndEngineerVacancy);
            service.Execute("Reject", frontEndEngineerVacancy);

            /**
            * Implement a logic of actions and invoke those actions below:
            */

            // Invoke "Submit for Approval" for softwareEngineerVacancy
            // Invoke "Approve" for softwareEngineerVacancy

            // Invoke "Submit for Approval" for frontEndEngineerVacancy
            // Invoke "Reject" for frontEndEngineerVacancy
        }
    }

    /**
    * Implement the service below the comment block

    public class <Service> {

    }

    */
    public interface IService
    {
        void Subscribe(String eventType, EventListener listener);
        void Unsubscribe(String eventType, EventListener listener);
        void Execute(String eventType, Record record);
    }
    public class Service : IService
    {
        private Dictionary<String, EventListener> events = new Dictionary<String, EventListener>();
        public void Subscribe(String eventType, EventListener listener)
        {
            this.events[eventType] = listener;
        }
        public void Unsubscribe(String eventType, EventListener listener)
        {
            this.events.Remove(eventType);
        }
        public void Execute(String eventType, Record record)
        {
            var listener = this.events[eventType];
            listener.Execute(record);
        }
    }

    public class Record {
        public String Id {get; private set;}
        public String Type {get; private set;}

        public Record(String Id, String Type) {
            this.Id = Id;
            this.Type = Type;
        }
    }

    public interface EventListener
    {
        void Execute(Record record);
    }
    public class SubmitForApproval : EventListener
    {
        public void Execute(Record record)
        {
            if ("Vacancy".Equals(record.Type))
            {
                Console.WriteLine("Submitted for approval Vacancy: " + record.Id);
            }
        }
    }
    public class Approve : EventListener
    {
        public void Execute(Record record)
        {
            if ("Vacancy".Equals(record.Type))
            {
                Console.WriteLine("Approved Record: " + record.Id);
            }
        }
    }
    public class Reject : EventListener
    {
        public void Execute(Record record)
        {
            if ("Vacancy".Equals(record.Type))
            {
                Console.WriteLine("Rejected Record: " + record.Id);
            }
        }
    }
}