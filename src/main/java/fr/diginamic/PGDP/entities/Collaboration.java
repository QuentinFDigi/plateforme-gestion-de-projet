package fr.diginamic.PGDP.entities;

import jakarta.persistence.*;

/** Classe contenant les différentes données liant les utilisateurs à leurs projets */
@Entity
@Table(name = "collaboration")
public class Collaboration {

    /** ID auto-générer en base de données */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    /** Variable contenant le role de l'utilisateur au seins d'un projet */
    @Column(name="role")
    private ProjectRole projectRole;

    /** Variable contenant les données du projet */
    @ManyToOne
    @JoinColumn(name="id_project")
    private Project project;

    /** Variable contenant les données de l'utilisateur */
    @ManyToOne
    @JoinColumn(name="id_User")
    private User user;

    /** Constructeur permettant la création d'une collaboration
     *
     * @param project Variable contenant les données du projet à ajouter
     * @param user Variable contenant les données de l'utilisateur à ajouter
     */
    public Collaboration(Project project, User user) {
        this.projectRole = ProjectRole.MEMBER;
        this.project = project;
        this.user = user;
    }

    /** Getter
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /** Getter
     *
     * @return projectRole
     */
    public ProjectRole getProjectRole() {
        return projectRole;
    }

    /** Setter
     *
     * @param projectRole Variable contenant le role du projet
     */
    public void setProjectRole(ProjectRole projectRole) {
        this.projectRole = projectRole;
    }

    /** Getter
     *
     * @return project
     */
    public Project getProject() {
        return project;
    }

    /** Setter
     *
     * @param project Variable contenant les données du projet en lien
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /** Getter
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /** Setter
     *
     * @param user Variable contenant les données de l'utilisateur en lien
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Collaboration{" +
                "id=" + id +
                ", projectRole=" + projectRole +
                ", project=" + project +
                ", user=" + user +
                '}';
    }
}
