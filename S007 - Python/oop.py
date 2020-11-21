class Employee():
    num_employees = 0
    raise_amount = 1.5
    def __init__(self, name):
        self.name = name
        self.username = self.name + "@" + "company.com"
        Employee.num_employees += 1
        

    def get_username(self):
        return self.username
    
    def set_salary(self, salary):
        self.salary = salary

    def get_salary(self):
        return self.salary

    @classmethod
    def change_raise(cls, new_amount):
        cls.raise_amount = new_amount



class Developer(Employee):
    def __init__(self, name, prog_lang):
        super().__init__(name)
        self.prog_lang = prog_lang



print(Employee.num_employees)

dev1 = Developer("mehsrhad", "python")
dev2 = Developer("ali", "java")
dev1.set_salary(12)
print(dev1.get_salary())
dev2.set_salary(10)
print(dev2.get_salary())
Employee.change_raise(1.8)
print(dev1.raise_amount)


