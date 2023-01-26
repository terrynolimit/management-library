management library
import java.util.Scanner;
import java.util.Random;
class Livres{
	public String categorie;
	public String code;
	public String titre;
	public String auteur;
	public int nbExemplaire;
	Scanner sc=new Scanner(System.in);
	
	Livres lv[]=new Livres[3];
	
	 void enregistrer(){
     for(int i=0;i<lv.length;i++){
		 lv[i]=new Livres();
	   System.out.print("Categorie:");
	   this.lv[i].categorie=sc.nextLine();
	   System.out.print("Titre:");
	   this.lv[i].titre=sc.nextLine();
	   System.out.print("Auteur:");
	   this.lv[i].auteur=sc.nextLine();
	    String nbExemplaire2=null;
	   do{
	   System.out.print("Nb Exemplaire:");
	   nbExemplaire2=sc.nextLine();
	   }
	   while(testNbExemplaire(String.valueOf(nbExemplaire2))==false);
	   
	   this.lv[i].nbExemplaire=Integer.parseInt(nbExemplaire2);
	 
	  // sc.nextLine();
	   Random r=new Random();
	   this.lv[i].code=lv[i].categorie.substring(0,1)+
	         lv[i].titre.substring(0,1)+"-"+(i+1);
			 
	   //lv[i].code=lv[i].categorie.substring(0,1)+
	     //    lv[i].titre.substring(0,1)+r.nextInt(0,100);
	
	 }
	 
	}
	void afficher(){
		for(Livres l:lv){
			if(!l.code.equalsIgnoreCase("supp")){
			System.out.println(l.toString());
			System.out.println("-------------------------------");
			}
		}
	}
	Livres rechercherLivre(){
		String nvCode;
		Livres resultat=null;
		do{
		System.out.print("Entrer le code de l'ouvrage a rechercher:");
		nvCode=sc.nextLine();
		}while(nvCode.isEmpty());
		for(Livres l:lv){
			if(l.code.equalsIgnoreCase(nvCode)){
				resultat=l;
			}
		}
		return resultat;
	}
	void rechercher(){
		Livres lv=rechercherLivre();
		if(lv==null)
	       	System.out.print("Oyvrage non enregistre sur le Systeme:");
		else{
			System.out.print(lv.toString());
			System.out.print("--------------------------------------------\n");
	
	
		}
	}
	
	boolean testNbExemplaire(String nbExemplaire){
		boolean resultat=true;
		for(int i=0;i<nbExemplaire.length();i++){
			char c=nbExemplaire.charAt(i);
			if(!Character.isDigit(c)){
				resultat=false;
				break;
			}
		}
		return resultat;
	}
	void modifier(){
		Livres modifier=rechercherLivre();
		String nvTitre=null;
		if(modifier==null)
	       	System.out.print("Oyvrage non enregistre sur le Systeme:");
		else{
			System.out.print(modifier.toString());
			System.out.print("--------------------------------------------\n");
			do{
			System.out.println("Entr er le nouveau titre de l'ourage");
			nvTitre=sc.nextLine();
			}while(nvTitre.isEmpty());
	        modifier.titre=nvTitre;
	
		}
	}
	void supprimer(){
      Livres supprimer=rechercherLivre();
		String rep=null;
		if(supprimer==null)
	       	System.out.print("Ouvrage non enregistre sur le Systeme:");
		else{
			System.out.print(supprimer.toString());
			System.out.print("--------------------------------------------\n");
			do{
			System.out.println("Voulez-vous vraiment supprimer ce livre(o/n)?");
			rep=sc.nextLine();
			}while(!rep.equalsIgnoreCase("o") && !rep.equalsIgnoreCase("n") );
	        if(rep.equalsIgnoreCase("o")){
				supprimer.code="supp";
				supprimer.titre="";
				supprimer.auteur="";
				supprimer.categorie="";
				supprimer.nbExemplaire=0;
				
	
			}
			
		}
		
	}
	
	public String toString(){
		return "Code         :"+code+"\n"+
		       "categorie    :"+categorie+"\n"+
			   "Titre        :"+titre+"\n"+
			   "Auteur       :"+auteur+"\n"+
			   "Nb Exemplaire:"+nbExemplaire;
	}
	
public static void main(String a[]){
    Scanner sc1=new Scanner(System.in);
    Livres lv=new Livres();
	int c=0;
	do{
	System.out.println("1.Enregistrer");
	System.out.println("2.Afficher");
	System.out.println("3.Rechercher");
	System.out.println("4.Modifier");
	System.out.println("5.Supprimer");
	System.out.println("6.Quitter");
	System.out.print("Option choisie:");
	c=sc1.nextInt();
	switch(c){
		case 1:
		lv.enregistrer();
		break;
		case 2:
		lv.afficher();
		break;
		case 3:
		lv.rechercher();
		break;
		case 4:
		lv.modifier();
		break;
		case 5:
		lv.supprimer();
		break;
		case 6:
		System.exit(0);
		break;
		default:
		System.out.println("Il faut saisir une option du menu !");
	}
	}while(c<=6);
	
	
}
	
	
}