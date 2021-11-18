
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SalihaSAGOL
 */
public class ProjectCode extends javax.swing.JFrame {

    /**
     * Creates new form ProjectCode
     */
    static DefaultTableModel dtm = new DefaultTableModel();
    static DefaultListModel dlm = new DefaultListModel();

    public ProjectCode() {
        initComponents();

        dtm.setColumnIdentifiers(new Object[]{"Population"});
        list_data2.setModel(dtm);
        list_outliers.setModel(dlm);

    }
    double mean = 0;
    double median = 0;

    ArrayList<Integer> pop = new ArrayList<Integer>();

    public void connection() {
        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/COUNTRY", "saliha", "1234");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM APP.WORLD");
            while (rs.next()) {
                pop.add(rs.getInt("POPULATION"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public double mean() {
        double[] tempArray = new double[pop.size()];                // dataları sıralamak için dizi oluşturdum
        for (int i = 0; i < pop.size(); i++) {                      // datalarımın bulunduğu arraylisti gezindim ve
            tempArray[i] = pop.get(i);                              // sıralama yapmak istedğim için yeni oluşturduğum
        }                                                           // arraye hepsini geçirdim
        Arrays.sort(tempArray);                                     // sıralama fonk. çağırdım
        double total = 0;                                           //  toplamı tutmak için bir değişken tanımladım

        for (int i = 0; i < tempArray.length; i++) {                // datalarımın sıralandığı arrayimi dolandım
            total += tempArray[i];                                  // ve toplam değişkenimle bu arraydeki elemanları topladım
        }
        mean = total / pop.size();                                  // ortalama hesabı içinde dataların toplamını data sayısına böldüm
        return mean;

    }

    public double median() {
        double[] tempArray = new double[pop.size()];                
        for (int i = 0; i < pop.size(); i++) {
            tempArray[i] = pop.get(i);
        }
        Arrays.sort(tempArray);

        if (pop.size() % 2 == 0) {    // çift ise                      // verilerimin sayısı çift ise
            median = ((double) tempArray[pop.size() / 2]);             // data sayısını ikiye böldüm ve ona karşılık gelen
        } else {                      // tek ise                       // elemanı yazdırdım, ama eğer eleman sayısı tek ise
            median = ((double) tempArray[(pop.size() - 1) / 2]         // bir eksiği ve bir fazlasını 2 ye bölerek topladım ve bunu da 
                    + (double) tempArray[(pop.size() + 1) / 2]) / 2;   // ikiye bölerek medyan sonucumu bulmuş oldum
        }
        return median;
    }

    public double standardDev() {
        double[] tempArray = new double[pop.size()];                    // dataları sıralamak için dizi oluşturdum
        for (int i = 0; i < pop.size(); i++) {                          // datalarımın bulunduğu arraylisti gezindim ve
            tempArray[i] = pop.get(i);                                  // sıralama yapmak istedğim için yeni oluşturduğum
        }                                                               // arraye hepsini geçirdim
        Arrays.sort(tempArray);                                         // sıralama fonk. çağırdım
        double total = 0;                                               //  toplamı tutmak için bir değişken tanımladım

        for (int i = 0; i < tempArray.length; i++) {                    // datalarımın sıralandığı arrayimi dolandım
            total += tempArray[i];                                      // ve toplam değişkenimle bu arraydeki elemanları topladım
        }
        double mean = total / pop.size();                               // ortalama hesabı yaptım 

        for (int k = 0; k < pop.size(); k++) {                          // data sayım kadar dizimi dolandım
            double r = (double) Math.pow((tempArray[k] - mean), 2);     // her elemandan ortalamayı çıkararak karesini aldım
            total += r;                                                 // ve bu değerleri topladım
        } 
        double k = total / pop.size();                                  // data sayıma böldüm bu değerinde karekökünü
        double standard_Devition = Math.sqrt(k);                        // alarak sonuca ulaştım

        return standard_Devition;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_mean = new javax.swing.JButton();
        btn_median = new javax.swing.JButton();
        btn_variance = new javax.swing.JButton();
        btn_standarddeviation = new javax.swing.JButton();
        btn_standarderror = new javax.swing.JButton();
        btn_distribution = new javax.swing.JButton();
        btn_outliers = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_mean = new javax.swing.JTextField();
        txt_median = new javax.swing.JTextField();
        btn_list = new javax.swing.JButton();
        txt_serror = new javax.swing.JTextField();
        txt_deviation = new javax.swing.JTextField();
        txt_outliers = new javax.swing.JTextField();
        txt_variance = new javax.swing.JTextField();
        txt_dist = new javax.swing.JTextField();
        btn_histogram = new javax.swing.JButton();
        btn_boxplot = new javax.swing.JButton();
        txt_boxplot = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_data2 = new javax.swing.JTable();
        btn_confidencemean = new javax.swing.JButton();
        txt_intervalmean = new javax.swing.JTextField();
        btn_confidencevariance = new javax.swing.JButton();
        txt_intervalvariance = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_outliers = new javax.swing.JList<>();
        btn_howbig = new javax.swing.JButton();
        txt_howbig = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_mean.setBackground(new java.awt.Color(204, 182, 204));
        btn_mean.setText("Mean of Column Data");
        btn_mean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_meanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mean, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 250, -1));

        btn_median.setBackground(new java.awt.Color(204, 182, 204));
        btn_median.setText("Median of Column Data");
        btn_median.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_medianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_median, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 250, -1));

        btn_variance.setBackground(new java.awt.Color(204, 182, 204));
        btn_variance.setText("Variance of Column Data");
        btn_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_varianceActionPerformed(evt);
            }
        });
        getContentPane().add(btn_variance, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, 250, -1));

        btn_standarddeviation.setBackground(new java.awt.Color(204, 182, 204));
        btn_standarddeviation.setText("Standard Deviation of Column Data");
        btn_standarddeviation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_standarddeviationActionPerformed(evt);
            }
        });
        getContentPane().add(btn_standarddeviation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, 250, -1));

        btn_standarderror.setBackground(new java.awt.Color(204, 182, 204));
        btn_standarderror.setText("Standard Error of Column Data ");
        btn_standarderror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_standarderrorActionPerformed(evt);
            }
        });
        getContentPane().add(btn_standarderror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 332, 250, -1));

        btn_distribution.setBackground(new java.awt.Color(204, 182, 204));
        btn_distribution.setText("Shape of Distribution of Column Data");
        btn_distribution.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_distributionActionPerformed(evt);
            }
        });
        getContentPane().add(btn_distribution, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 290, -1));

        btn_outliers.setBackground(new java.awt.Color(204, 182, 204));
        btn_outliers.setText("Outliers of Column Data");
        btn_outliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_outliersActionPerformed(evt);
            }
        });
        getContentPane().add(btn_outliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 220, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 462, -1));
        getContentPane().add(txt_mean, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));
        getContentPane().add(txt_median, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, 250, -1));

        btn_list.setBackground(new java.awt.Color(204, 182, 204));
        btn_list.setText("List of Column Data");
        btn_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listActionPerformed(evt);
            }
        });
        getContentPane().add(btn_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 190, -1));
        getContentPane().add(txt_serror, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 361, 250, -1));
        getContentPane().add(txt_deviation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 285, 250, -1));
        getContentPane().add(txt_outliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 220, -1));
        getContentPane().add(txt_variance, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 196, 250, -1));
        getContentPane().add(txt_dist, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 290, -1));

        btn_histogram.setBackground(new java.awt.Color(204, 182, 204));
        btn_histogram.setText("Histogram");
        btn_histogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_histogramActionPerformed(evt);
            }
        });
        getContentPane().add(btn_histogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 290, -1));

        btn_boxplot.setBackground(new java.awt.Color(204, 182, 204));
        btn_boxplot.setText("BoxPlot");
        btn_boxplot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_boxplotActionPerformed(evt);
            }
        });
        getContentPane().add(btn_boxplot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 250, -1));
        getContentPane().add(txt_boxplot, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 364, -1));

        list_data2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        list_data2.setGridColor(new java.awt.Color(204, 182, 204));
        list_data2.setSelectionForeground(new java.awt.Color(204, 182, 204));
        jScrollPane1.setViewportView(list_data2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 270, 341));

        btn_confidencemean.setBackground(new java.awt.Color(204, 182, 204));
        btn_confidencemean.setText("Confidence Interval for Mean");
        btn_confidencemean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confidencemeanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confidencemean, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 290, -1));
        getContentPane().add(txt_intervalmean, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 290, -1));

        btn_confidencevariance.setBackground(new java.awt.Color(204, 182, 204));
        btn_confidencevariance.setText("Confidence Interval for Variance");
        btn_confidencevariance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confidencevarianceActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confidencevariance, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 290, -1));
        getContentPane().add(txt_intervalvariance, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 290, -1));

        jScrollPane2.setViewportView(list_outliers);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 140, 260));

        btn_howbig.setBackground(new java.awt.Color(204, 182, 204));
        btn_howbig.setText("How Big a Sample is Needed for The Data?");
        btn_howbig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_howbigActionPerformed(evt);
            }
        });
        getContentPane().add(btn_howbig, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 290, -1));
        getContentPane().add(txt_howbig, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 290, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 140, 30));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 160, 40, 0));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_meanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_meanActionPerformed
        // TODO add your handling code here:
        connection();
        mean();
        String formatResult = (new DecimalFormat("##.##").format(mean));  // ortalamayı formatlı yazdırmak için yazdığım fonksiyon
        txt_mean.setText(String.valueOf(formatResult));                   // hesapladığım ortalama değerini jframe de textfield alanına yazdırdım

    }//GEN-LAST:event_btn_meanActionPerformed

    private void btn_medianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_medianActionPerformed
        // TODO add your handling code here:
        connection();
        median();
        String formatResult = (new DecimalFormat("##.##").format(median));
        txt_median.setText(String.valueOf(formatResult));

    }//GEN-LAST:event_btn_medianActionPerformed

    private void btn_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listActionPerformed
        // TODO add your handling code here:

        ProjectCode p = new ProjectCode();
        p.dtm.setRowCount(0);
        try {
            Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/COUNTRY", "saliha", "1234");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM APP.WORLD");
            while (rs.next()) {
                pop.add(rs.getInt("POPULATION"));
                int population = rs.getInt("POPULATION");
                ProjectCode.dtm.addRow(new Object[]{population});
                rs.getMetaData().getColumnCount();

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_btn_listActionPerformed

    private void btn_histogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_histogramActionPerformed
        // TODO add your handling code here:
        connection();

        double[] tempArray = new double[pop.size()];
        for (int i = 0; i < pop.size(); i++) {
            tempArray[i] = pop.get(i);
        }
        Arrays.sort(tempArray);

        int number = 9;                                     // log 2 tabanında data sayısı yani 227 + 1  bu da 8... bir değer çıkıyordu 9 a yuvarladım
        HistogramDataset hdata = new HistogramDataset();    // HistogramDataset türünde bir nesne oluşturdum

        hdata.setType(HistogramType.FREQUENCY);             // ve bu nesnenin tipini histgam olarak aldım
        hdata.addSeries("Histogram", tempArray, number);    // ve 
        String plotTitle = "Histogram graf";                // grafik başlığı ekledim
        String xaxis = "Population";                        // x ekseni için ne yazılcak onu ekledim
        String yaxis = "value";                             // y ekseni için ne yazılcak onu ekledim
 
        PlotOrientation orientation = PlotOrientation.VERTICAL;        // freechart ve jcommon kütüphaneleri ekliyorum

        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis, yaxis, // burada histogramı oluşturorum
                hdata, orientation, false, false, false);
        
        ChartFrame chartfrm = new ChartFrame("POPULATION", chart, true);    // 
        chartfrm.setVisible(true);                           // görünür yaptım
        chartfrm.setSize(710, 700);                          // ekran boyutları

    }//GEN-LAST:event_btn_histogramActionPerformed

    private void btn_standarddeviationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_standarddeviationActionPerformed
        // TODO add your handling code here:
        connection();
        standardDev();
        String formatResult = (new DecimalFormat("##.##").format(standardDev()));
        txt_deviation.setText(String.valueOf(formatResult));

    }//GEN-LAST:event_btn_standarddeviationActionPerformed

    private void btn_varianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_varianceActionPerformed
        // TODO add your handling code here:
        connection();
        double sd = standardDev();                                           // standart sapma metodunu çağırıyorum
        double variance = Math.pow(sd, 2);                                   // variance formülü standart sapmanın karesiydi direkt hesapladım
        String formatResult = (new DecimalFormat("##.##").format(variance));
        txt_variance.setText(String.valueOf(formatResult));

    }//GEN-LAST:event_btn_varianceActionPerformed

    private void btn_boxplotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_boxplotActionPerformed
        // TODO add your handling code here:
        connection();                                // db bağlantımı yapıyorum

        double q1, q3 = 0;                           // quartile 1 ve 3 ü tanımlıyorum
        double q2 = median();                        // quartile 2 zaten %50 olduğu için direkt medyana eşit oluyordu

        double[] tempArray = new double[pop.size()];

        for (int i = 0; i < pop.size(); i++) {
            tempArray[i] = pop.get(i);
        }

        Arrays.sort(tempArray);
        ArrayList q1_list = new ArrayList();          // quartile 1 için bir arraylist oluşturdum
        ArrayList q3_list = new ArrayList();          // quartile 2 için bir arraylist oluşturdum
        
        for (int i = 0; i < tempArray.length; i++) {           // for döngü oluşturyorum ve data sayıma kadar dönüyorum
            if (tempArray[i] < q2) {                  // bu dizideki elemanları tek tek dolanıyorum ve eğer q2 yani medyandan küçükse
                q1_list.add(i, tempArray[i]);         // q1 arraylistine bu medyandan küçük olan değerleri ekliyorum
            }
            if (tempArray[i] > q2) {                  // ama eğer medyandan küçükse bu elemanlar
                q3_list.add(tempArray[i]);            // q3 arraylistine ekleme yapıyorum
            }
        }
        if (q1_list.size() % 2 == 0) {                // bu q1 arraylistinin eleman sayısı çift ise
            q1 = ((double) q1_list.get((q1_list.size() - 1) / 2) + (double) q1_list.get(q1_list.size() / 2)) / 2.0;  // formülümü uyguluyorum
        } else {                                      // eğer tek ise
            q1 = (double) q1_list.get(((q1_list.size() + 1) / 2 - 1)) / 1.0;  // formülümü uyguluyorum
        }

        if (q3_list.size() % 2 == 0) {                // q3 içinde aynı işlemleri tekrarlıyorum
            q3 = ((double) q3_list.get((q3_list.size() - 1) / 2) + (double) q3_list.get(q3_list.size() / 2)) / 2.0;
        } else {
            q3 = (double) q3_list.get(((q3_list.size() + 1) / 2 - 1)) / 1.0;
        }

        System.out.println("Q1 : " + q1);
        System.out.println("Q2 : " + q2);
        String formatq3 = (new DecimalFormat("##.##").format(q3));
        System.out.println("Q3 : " + formatq3);

        double maxValue = tempArray[0];
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] > maxValue) {
                maxValue = tempArray[i];
            }
        }
        double minValue = tempArray[0];
        for (int i = 1; i < tempArray.length; i++) {
            if (tempArray[i] < minValue) {
                minValue = tempArray[i];
            }
        }
        System.out.println("Min : " + minValue);
        String formatResult2 = (new DecimalFormat("##.##").format(maxValue));
        System.out.println("Max : " + formatResult2);

        txt_boxplot.setText(String.valueOf("Q1 : " + q1 + "  and   Q2 : " + q2 + "  and   Q3 : " + formatq3));

        /*
               -------|----------
               |      |         |
               |      |         |
        ----[---------|--------------]-----------------*1313973713      
     -25391937 |      |         |   43482911
               |      |         |
               -------|----------  
          436131   4786994     17654843
         */
    }//GEN-LAST:event_btn_boxplotActionPerformed

    private void btn_distributionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_distributionActionPerformed
        // TODO add your handling code here:
        connection();                                    // database bağlantısı için metodumu çağırıyorum

        if (mean() == median()) {                        // eğer ortalama ve medyan değerim eşitse bu şekil simetriktir
            String result = "Symmetrical";               // o yüzden text field alanına
            txt_dist.setText(String.valueOf(result));    // simetrik yazdırıyorum
        }
        if (mean() > median()) {                         // eğer ortalama değeri medyandan büyük çıkarsa bu da sağa eğik olur 
            String result = "Right-skewed";              // o yüzden text field alanına      
            txt_dist.setText(String.valueOf(result));    // sağa eğik yazdırıyorum
        } else {                                         // bu koşullar dışında çıkarsa yani ortalam medyandan küçük olduğu zaman
            String result = "Left-skewed";               // bu sola eğik olur ve
            txt_dist.setText(String.valueOf(result));    // text feld alanına bunu yazdırdım
        }

    }//GEN-LAST:event_btn_distributionActionPerformed

    private void btn_outliersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_outliersActionPerformed
        // TODO add your handling code here:
        connection();                                      // database bağlantısını yaptığım metodumu çağırıyorum

        double q1, q3 = 0;                                 // aşağıdaki fonk. kullanmak üzere double türünde q1 ve q3 tanımlıyorum

        double[] tempArray = new double[pop.size()];         // datalarımın bulunduğu arraylisti işlem yapabilmek için diziye aktarıyorum
        for (int i = 0; i < pop.size(); i++) {             // arraylistte dolanıp
            tempArray[i] = pop.get(i);                       // arraylistte bulunan her bir elemanı diziye aktarıyorum
        }

        double q2 = median();                              // q2 değerim direkt mediyana eşit olduğu için medyan metodumu çağırdım
        Arrays.sort(tempArray);                              // datalarımı hazır sıralama fonk. ile sıralıyorum, işlemler buna göre olacak

        ArrayList q1_list = new ArrayList();               // q1 listesini tutabilmek için bir arry list oluşturuorum
        ArrayList q3_list = new ArrayList();               // aynı şekilde q3 içinde oluşturuyorum
        for (int i = 0; i < tempArray.length; i++) {         // datalarımı aktardığımı diziyi dolanarak
            if (tempArray[i] < q2) {                         // medyanı dizinin elemanların gezerek tek tek karşılaştırıyorum
                q1_list.add(i, tempArray[i]);                // eğer medyan bu dizideki elemanlardan büyükse
            }                                              // q1 adlı yeni oluşturudğum diziye eklemesini söylüyorum
            if (tempArray[i] > q2) {                         // aynı şekilde burda eğer medyan bu elemanlardan küçükse
                q3_list.add(tempArray[i]);                   // q3 listesine eklemesini söylüyorum
            }
        }
        if (q1_list.size() % 2 == 0) {                     // bu ekleme yaptığım q1 dizisindeki elemanlar eşit bölünüyorsa yani mod2=0 ise
            q1 = ((double) q1_list.get((q1_list.size() - 1) / 2) + (double) q1_list.get(q1_list.size() / 2)) / 2.0;
        } else {                                           // ortadan eşit ayrılmıyorsa da
            q1 = (double) q1_list.get(((q1_list.size() + 1) / 2 - 1)) / 1.0;                   // formülümü kulanıyorum
        }

        if (q3_list.size() % 2 == 0) {                                  // aynı q1 de yaptığım işlemleri q3 içinde yapıyorum
            q3 = ((double) q3_list.get((q3_list.size() - 1) / 2) + (double) q3_list.get(q3_list.size() / 2)) / 2.0;
        } else {
            q3 = (double) q3_list.get(((q3_list.size() + 1) / 2 - 1)) / 1.0;
        }
        double IQR = q3 - q1;                                       // IQR yi hesaplamak için q3 den a1 i çıkarıyorum
        double beg = q1 - (1.5 * IQR);                              // outlier bulabilmem için aralıkları hesaplıyorum, başlangıç aralığı formülünü yazıyorum ve
        double end = q3 + (1.5 * IQR);                              // bitiş aralığı formülünü yazıyorum

        for (int i = 0; i < pop.size(); i++) {                      // Benim datalarımın içinde bu aralıkların dışında kalan var mı ona bakıyrorum
            if (tempArray[i] < beg || tempArray[i] > end) {             // eğer benim dizimdeki elemanlardan bizi başlangıçtan küçük veya bitiş aralığından büyükse
                String outliers = "There are outliers";             // dışarda kalan değer, outlier var demektir diyorum ve
                String format_beg = (new DecimalFormat("##.##").format(tempArray[i]));
                dlm.addElement(format_beg);                         // outlier değerleri listeye yazdırıyorum
                txt_outliers.setText(String.valueOf(outliers));     // text field alanına outlier olduğunu yazıdıryorum
            } else {                                                // eğer bu koşula uymyorsa da aralık içinde kalıyordur değerlerim ve
                String outliers = "There is not outliers";          // outliers yok demektir ve 
                txt_outliers.setText(String.valueOf(outliers));     // text field alanına yazdırıyorum
            }
        }

    }//GEN-LAST:event_btn_outliersActionPerformed

    private void btn_standarderrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_standarderrorActionPerformed
        // TODO add your handling code here:

        connection();                                 // database bağlantımı yapıyorum
        double sd = standardDev();                    // standart sapmayı hesapladığım metodu çağırıp sd değişkenine atıyorum
        double n = pop.size();                        // datalarımın bulunduğu ArrayLİst uzunluğunu n değişkenine atıyorum
        double sq_n = Math.sqrt(n);                   // math metodu ile data sayısının karesi alıyorum
        double s_error = sd / sq_n;                   // standart error formülü de standart sapma / kök n bunu hesaplıyrum ve

        txt_serror.setText(String.valueOf(s_error));  // textfield alanına yazdırıyorum
        
    }//GEN-LAST:event_btn_standarderrorActionPerformed

    private void btn_confidencemeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confidencemeanActionPerformed
        // TODO add your handling code here:
        double sum = 0;
        double alfa = 0.05;                                           // burada alfanın 0.05 olmasının sebebi %95 olması
        double z_alfa = alfa / 2;
        double z = 1.96;
        int sampleArray_length = 20;
        Random randArray = new Random();                              // datalarımın içinden random 20 tane alıyorum
        double[] tempArray = new double[pop.size()];

        for (int i = 0; i < pop.size(); i++) {
            tempArray[i] = pop.get(i);
        }
        Arrays.sort(tempArray);

        for (int i = 0; i < sampleArray_length; i++) {                                     // burada 20 adet random veri seçtim ve
            sum += randArray.nextInt(sampleArray_length);                                  // bunları birbiriyle topladım
        }                                                                                  // daha sonra topladığım değerleri 
        double samplemean = sum / sampleArray_length;                                      // data sayısına bölerek ortalamayı buldum, sample mean

        double begin_interval = samplemean - (z * (standardDev() / Math.sqrt(sampleArray_length)));        // başlangıç aralığı için formülümü uyguladım
        double end_interval = samplemean + (z * (standardDev() / Math.sqrt(sampleArray_length)));          // bitiş aralığı için formülümü uyguladım 

        if (standardDev() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please Calculate The Standard Deviation First");
        } else {
            String format_beg = (new DecimalFormat("##.##").format(begin_interval));
            String format_end = (new DecimalFormat("##.##").format(end_interval));
            String confidence_Interval_mean = "[ " + format_beg + " /// " + format_end + " ]";
            txt_intervalmean.setText(String.valueOf(confidence_Interval_mean));
        }

    }//GEN-LAST:event_btn_confidencemeanActionPerformed

    private void btn_confidencevarianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confidencevarianceActionPerformed
        // TODO add your handling code here:
        int sum = 0;
        int sampleArray_length = 20;
        Random randArray = new Random();
        double[] tempArray = new double[pop.size()];

        for (int i = 0; i < pop.size(); i++) {
            tempArray[i] = pop.get(i);
        }
        Arrays.sort(tempArray);

        for (int j = 0; j < sampleArray_length; j++) {
            sum += randArray.nextInt(sampleArray_length);
        }
        double mean = sum / sampleArray_length;

        for (int k = 0; k < sampleArray_length; k++) {
            double r = (double) Math.pow((tempArray[k] - mean), 2);
            sum += r;
        }
        double k = sum / sampleArray_length;                                                    // mean hesapladım
        double standard_Devition = Math.sqrt(k);                                                // standart sapmasını buldum
        double variance = Math.pow(standard_Devition, 2);                                       // sd nin karesini aldım ve variance buldum
        double begin_interval = ((sampleArray_length - 1) * Math.pow(variance, 2)) / 32.9;      // baş. aralığı için formül df 19 ve alfa 0,025 tablodan 32.9
        double end_interval = ((sampleArray_length - 1) * Math.pow(variance, 2)) / 8.91;        // df 19 ve alfa 0,975 tablodan 8,91

        String format_beg = (new DecimalFormat("##.##").format(begin_interval));
        String format_end = (new DecimalFormat("##.##").format(end_interval));
        String confidence_Interval_variance = "[ " + format_beg + " /// " + format_end + " ]";
        txt_intervalvariance.setText(String.valueOf(confidence_Interval_variance));
        
    }//GEN-LAST:event_btn_confidencevarianceActionPerformed

    private void btn_howbigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_howbigActionPerformed
        // TODO add your handling code here:
        double marjin = 0.1, alfa = 0.1;
        double alfa_z = alfa / 2;                                           // 0,05 çıkar
        double z_value = 1.645;                                             // z0,05 = 1.645

        double big = Math.pow((z_value * standardDev() / marjin), 2);      // benim n değerim bundan büüyk olması gerekiyor 
        big += 1;                                                           // o yüzden 1 artırarak yazdırıyorum
        String format_big = (new DecimalFormat("##.##").format(big));
        txt_howbig.setText(String.valueOf(format_big));

    }//GEN-LAST:event_btn_howbigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectCode.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectCode.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectCode.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectCode.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectCode().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_boxplot;
    private javax.swing.JButton btn_confidencemean;
    private javax.swing.JButton btn_confidencevariance;
    private javax.swing.JButton btn_distribution;
    private javax.swing.JButton btn_histogram;
    private javax.swing.JButton btn_howbig;
    private javax.swing.JButton btn_list;
    private javax.swing.JButton btn_mean;
    private javax.swing.JButton btn_median;
    private javax.swing.JButton btn_outliers;
    private javax.swing.JButton btn_standarddeviation;
    private javax.swing.JButton btn_standarderror;
    private javax.swing.JButton btn_variance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable list_data2;
    private javax.swing.JList<String> list_outliers;
    private javax.swing.JTextField txt_boxplot;
    private javax.swing.JTextField txt_deviation;
    private javax.swing.JTextField txt_dist;
    private javax.swing.JTextField txt_howbig;
    private javax.swing.JTextField txt_intervalmean;
    private javax.swing.JTextField txt_intervalvariance;
    private javax.swing.JTextField txt_mean;
    private javax.swing.JTextField txt_median;
    private javax.swing.JTextField txt_outliers;
    private javax.swing.JTextField txt_serror;
    private javax.swing.JTextField txt_variance;
    // End of variables declaration//GEN-END:variables

}
