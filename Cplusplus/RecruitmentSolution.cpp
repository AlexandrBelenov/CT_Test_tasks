#include <iostream>
#include <list>
#include <string>

using namespace std;

class Record {
  private:
    string id;
    string type;
  public:
    Record (string i, string t) {
      id = i;
      type = t;
    }
    string getId () {
      return id;
    }
    string getType (){
      return type;
    }
};

class IObserver {
  public:
  virtual void Update(const std::string &message, Record *record) = 0;
};

class ISubject {
  public:
    virtual ~ISubject(){};
    virtual void Attach(IObserver *observer) = 0;
    virtual void Detach(IObserver *observer) = 0;
    virtual void Notify() = 0;
};

class Subject : public ISubject {
  private:
    std::list<IObserver*> list_observer_;
    std::string message_;
  public:
    void Attach(IObserver *observer) override {
      list_observer_.push_back(observer);
    }
    void Detach(IObserver *observer) override {
      list_observer_.remove(observer);
    }
};

class Observer : public IObserver {
  private:
    string message;
    Subject &subject_;
    static int static_number_;
    int number_;
  public:
    Observer(Subject &subject) : subject_(subject) {
      this->subject_.Attach(this);
    }
    void Update(const string &message) override {
      this->message = message;
    }
};

int main () {
  // Unfinished
  string recordType = "Vacancy";
  Record softwareEngineerVacancy ("SoftwareEngineer0001", recordType);
  Record frontEndEngineerVacancy ("FrontEndEngineer0020", recordType);
  
  Subject *subject = new Subject;
  Observer *observer1 = new Observer(*subject);
  Observer *observer2 = new Observer(*subject);
  Observer *observer3 = new Observer(*subject);

  delete observer3;
  delete observer2;
  delete observer1;
  delete subject;

  return 0;
}
