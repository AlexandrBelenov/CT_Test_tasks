class Record {
    constructor(id, type) {
        this.id = id;
        this.type = type;
    }
    getId() {
        return this.id;
    }
    getType() {
        return this.type;
    }
}

class Service {
    constructor(){
        this.observers = [];
    }
    subscribe(fn) {
        this.observers.push(fn);
    }
    unsubscribe (fn) {
        this.observers = this.observers.filter(subscriber => subscriber !== fn);
    }
    execute(action, record) {
        this.observers.forEach(subscriber => {
            if (action === subscriber.name) {
                subscriber(record);
            }
        });
    }
    executeAny(actions, record) {
        actions.forEach(action =>{
            this.observers.forEach(subscriber => {
                if (action === subscriber.name) {
                    subscriber(record);
                }
            });
        });
    }
}

const recordType = "Vacancy";
const softwareEngineerVacancy = new Record("SoftwareEngineer0001", recordType);
const frontEndEngineerVacancy = new Record("FrontEndEngineer0020", recordType);

const submitForApproval = record =>  {
    if ("Vacancy" === record.getType()) {
        console.log("Submitted for approval Vacancy:", record.getId());
    } 
};
const approve = record =>  {
    if ("Vacancy" === record.getType()) {
        console.log("Approved Record:", record.getId());
    } 
};
const reject = record =>  {
    if ("Vacancy" === record.getType()) {
        console.log("Rejected Record:", record.getId());
    }
};

const service = new Service();
service.subscribe(submitForApproval);
service.subscribe(approve);
service.subscribe(reject);

// service.execute("submitForApproval", softwareEngineerVacancy);
// service.execute("approve", softwareEngineerVacancy);
// service.execute("submitForApproval", frontEndEngineerVacancy);
// service.execute("reject", frontEndEngineerVacancy);

service.executeAny(["submitForApproval", "approve"], softwareEngineerVacancy);
service.executeAny(["submitForApproval", "reject"], frontEndEngineerVacancy);