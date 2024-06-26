public class Product

{

    protected String name = "";

    protected double price = 0.0;

    // Blank constructor method
    public Product()

    {

        ;

    }

    // Constructor method for CSV entry
    public Product(String CSVLine)

    {

        String[] data = CSVLine.split("\\|");
        this.name = data[0];
        this.price = Double.parseDouble(data[1]);

    }

    // Constructor method
    public Product(String name, double price)

    {

        this.name = name;
        this.price = price;

    }

    public void setName(String name)

    {

        this.name = name;

    } // void setName (String)

    public String getName()

    {

        return this.name;

    } // String getName ()

    public void setPrice(double price)

    {

        this.price = price;

    } // void setPrice (double)

    public double getPrice()

    {

        return this.price;

    } // double getPrice ()

    public String toCSV() {

        return this.name + "|" + this.price;

    }

    public String toString() {

        return "Name: " + this.name + "; Price: " + String.format("%.2d", this.price);

    }

} // end Product class
