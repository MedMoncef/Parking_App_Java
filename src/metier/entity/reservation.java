    package metier.entity;

    public class reservation {
        private int R_ID;
        private int PS_ID_R;
        private int C_ID;
        private String Date_Debut;
        private String Date_Fin;
        private int Duree;
        private double Prix;

        public reservation() {

        }

        public reservation(int R_ID, int PS_ID_R, int C_ID, String Date_Debut, String Date_Fin, int Duree, double Prix) {
            this.R_ID = R_ID;
            this.PS_ID_R = PS_ID_R;
            this.C_ID = C_ID;
            this.Date_Debut = Date_Debut;
            this.Date_Fin = Date_Fin;
            this.Duree = Duree;
            this.Prix = Prix;
        }

        public void setR_ID(int R_ID) {
            this.R_ID = R_ID;
        }

        public void setPS_ID_R(int PS_ID_R) {
            this.PS_ID_R = PS_ID_R;
        }

        public void setC_ID(int C_ID) {
            this.C_ID = C_ID;
        }

        public void setDate_Debut(String Date_Debut) {
            this.Date_Debut = Date_Debut;
        }

        public void setDate_Fin(String Date_Fin) {
            this.Date_Fin = Date_Fin;
        }

        public void setDuree(int Duree) {
            this.Duree = Duree;
        }

        public void setPrix(double Prix) {
            this.Prix = Prix;
        }

        public int getR_ID() {
            return R_ID;
        }

        public int getPS_ID_R() {
            return PS_ID_R;
        }

        public int getC_ID() {
            return C_ID;
        }

        public String getDate_Debut() {
            return Date_Debut;
        }

        public String getDate_Fin() {
            return Date_Fin;
        }

        public int getDuree() {
            return Duree;
        }

        public double getPrix() {
            return Prix;
        }
    }