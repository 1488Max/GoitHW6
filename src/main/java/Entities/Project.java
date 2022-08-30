package Entities;

import HibernateDao.CompanyDao;
import HibernateDao.CustomerDao;
import jakarta.persistence.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected long id;

    @Column(name = "name")
    @NonNull
    protected String name;

    @Column(name = "time_of_creation")
    @NonNull
    protected String timeOfCreation;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    protected Company company;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    protected Customer customer;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "developer_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    protected List<Developer> developers;


    public Project(String name, String timeOfCreation, long customerId, long companyId) {
        this.name = name;
        this.timeOfCreation = timeOfCreation;
        this.company = CompanyDao.getCompany(companyId);
        this.customer = CustomerDao.getCustomer(customerId);


    }

    public Project() {

    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time_of_creation='" + timeOfCreation + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public void setTimeOfCreation(String time_of_creation) {
        this.timeOfCreation = time_of_creation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }
}