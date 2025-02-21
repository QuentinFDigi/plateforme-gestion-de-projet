package fr.diginamic.PGDP.dtos.projects;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public class ProjectAddOrModifyDto {

    /** Vari able contenant le nom d'un projet */
    private String name;

    /** Variable indiquant la date de fin d'un projet */

    private LocalDate endDate;

    /** Variable contenant une description du projet */
    private String description;

    /** Variable contenant le moyen de contact pour le projet */
    private String contact;

    /** Getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /** Setter
     *
     * @param name nom du projet
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /** Setter
     *
     * @param endDate date de fin du projet
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /** Getter
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /** Setter
     *
     * @param description description du projet
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Getter
     *
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /** Setter
     *
     * @param contact moyen de contact du projet
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
                ", name='" + name + '\'' +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
