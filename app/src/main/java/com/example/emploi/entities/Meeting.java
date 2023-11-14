package com.example.emploi.entities;

public class Meeting {

    private int _id;
    private String meet_title;
    private String meet_link;
    private int meet_duree;
    private String meet_date;
    private String meet_salle;
    //private String idMatiere; // Foreign key to Matiere

    /* -------------------------------------------------------- */
    public int getIdMeet() {
        return _id;
    }
    public void setIdMeet(int _id) {
        this._id = _id;
    }

    /* -------------------------------------------------------- */
    public String getMeetTitle() {
        return meet_title;
    }
    public void setMeetTitle(String meet_title) {
        this.meet_title = meet_title;
    }

    /* -------------------------------------------------------- */
    public int getMeetDuree() {
        return meet_duree;
    }
    public void setMeetDuree(int meet_duree) {
        this.meet_duree = meet_duree;
    }

    /* -------------------------------------------------------- */
    public String getMeetLink() {
        return meet_link;
    }
    public void setMeetLink(String meet_link) {
        this.meet_link = meet_link;
    }

    /* -------------------------------------------------------- */
    public String getMeetDate() {
        return meet_date;
    }
    public void setMeetDate(String meet_date) {
        this.meet_date = meet_date;
    }

    /* -------------------------------------------------------- */
    public String getMeetSalle() {
        return meet_salle;
    }
    public void setMeetSalle(String meet_salle) {
        this.meet_salle = meet_salle;
    }

    /* -------------------------------------------------------- */
    public Meeting(int _id, String meet_title, int meet_duree, String meet_link, String meet_date, String meet_salle) {
        this._id=_id;
        this.meet_title=meet_title;
        this.meet_duree=meet_duree;
        this.meet_link=meet_link;
        this.meet_date=meet_date;
        this.meet_salle=meet_salle;
    }



    /* -------------------------------------------------------- */
    @Override
    public String toString() {
        return "Meeting{" +
                "_id=" + _id +
                ", meet_title='" + meet_title + '\'' +
                ", meet_duree='" + meet_duree + '\'' +
                ", meet_link='" + meet_link + '\'' +
                ", meet_date='" + meet_date + '\'' +
                ", meet_salle=" + meet_salle +
                '}';
    }

    /* -------------------------------------------------------- */
    public Meeting () {
    }



    /*public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }*/
}