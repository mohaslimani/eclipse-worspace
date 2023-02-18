package beans;


public class Emprunt {
		int ide;
		int idl;
		int date;
		boolean remis; 
		
		public Emprunt() {
			ide=0;
			idl=0;
			date=0;
		}
		
		public Emprunt(int ide, int idl, int date) {
			this.ide=ide;
			this.idl=idl;
			this.date=date;
		}
		
		public int getIde() {
			return(this.ide);
		}
		public int getIdl() {
			return(this.idl);
		}
		public int getDate() {
			return(this.date);
		}
		
		public void setRemis(int remis) 
		{
			this.remis = (remis == 0);
		}
		public void setIde(int ide) {
			this.ide=ide;
		}
		public void setIdl(int idl) {
			this.idl=idl;
		}
		
		public void setDate(int date) {
			this.date=date;
		}
		
		public String toString()
		{
			return ("le livre " + idl + ", emprunter par : " + ide + ", le: " + date + " " + remis);
		}
		
		public String tocsv()
		{
			return (ide + "," + idl + "," + date + "," + remis + "\n");
		}
		
}