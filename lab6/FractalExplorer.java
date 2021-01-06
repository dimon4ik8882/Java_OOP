import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

public class FractalExplorer
{
    //Поля для кнопок
    private JButton saveButton;
    private JButton resetButton;
    private JComboBox myComboBox;
    
    //поле кол-во строк и тд
    private int rowsRemaining;

    private int displaySize;

    private JImageDisplay display;

    // для каждого типа фракталов
    private FractalGenerator fractal;

    // диапазон
    private Rectangle2D.Double range;

    // конструктор, принимающий размер дисплея
    public FractalExplorer(int size) {
        // хранит размер
        displaySize = size;
        
        // инициализирует поля
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(displaySize, displaySize);
        
    }

    // Создание интерфейса, кнопок
    public void createAndShowGUI()
    {
        // создаем тайтл оконного приложения
        display.setLayout(new BorderLayout());
        JFrame myFrame = new JFrame("Fractal Explorer");
        
        // добавляем изображение в центр
        myFrame.add(display, BorderLayout.CENTER);

        resetButton = new JButton("Reset");

        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
        
        // обработка нажатия мыши
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);
        
        // закрытие
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myComboBox = new JComboBox();
        
        // добовление фракталов в комбобокс
        FractalGenerator mandelbrotFractal = new Mandelbrot();
        myComboBox.addItem(mandelbrotFractal);
        FractalGenerator tricornFractal = new Tricorn();
        myComboBox.addItem(tricornFractal);
        FractalGenerator burningShipFractal = new BurningShip();
        myComboBox.addItem(burningShipFractal);
        ButtonHandler fractalChooser = new ButtonHandler();
        myComboBox.addActionListener(fractalChooser);

        //Создание объектов JPanel и JLabel с JComboBox и вывод бокса сверху
        JPanel myPanel = new JPanel();
        JLabel myLabel = new JLabel("Fractal:");
        myPanel.add(myLabel);
        myPanel.add(myComboBox);
        myFrame.add(myPanel, BorderLayout.NORTH);

        // кнопка сохранения и сброса
        saveButton = new JButton("Save");
        JPanel myBottomPanel = new JPanel();
        myBottomPanel.add(saveButton);
        myBottomPanel.add(resetButton);
        myFrame.add(myBottomPanel, BorderLayout.SOUTH);
        
        // кнопка сохранения
        ButtonHandler saveHandler = new ButtonHandler();
        saveButton.addActionListener(saveHandler);
        
        
        // видимый фрейм и запрет изменения окна
        myFrame.pack();
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        
    }

    // метод отрисовки и изображения фрактала
    private void drawFractal()
    {
        // отключаем UI, чтобы пользователь не перегружал прогу в момент рисования
        enableUI(false);
        
        // устанавливаем в rowsRemaining общее кол-во строк
        rowsRemaining = displaySize;

        // проходимся циклом по кол-ву строк и вызываем FractalWorker чтобы нарисовать их
        for (int x=0; x<displaySize; x++){
            FractalWorker drawRow = new FractalWorker(x);
            drawRow.execute();
        }

    }

    private void enableUI(boolean val) {
        myComboBox.setEnabled(val);
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
    }

    // внутренний класс для обработки событий
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // дает строку, представляющую команду действия
            String command = e.getActionCommand();
            
            // если выбран комбо бокс, дать юзеру выбор фрактала
            if (e.getSource() instanceof JComboBox) {
                JComboBox mySource = (JComboBox) e.getSource();
                fractal = (FractalGenerator) mySource.getSelectedItem();
                //инициализация и отрисовка фрактала
                fractal.getInitialRange(range);
                drawFractal();
                
            }
             // если выбрана ресет, нарисовать фрактал
            else if (command.equals("Reset")) {
                fractal.getInitialRange(range);
                drawFractal();
            }
            // если выбрано сохранение, сохраненить текущий фрактал
            else if (command.equals("Save")) {
                
                // место для хранения места сохранения))
                JFileChooser myFileChooser = new JFileChooser();
                
                // сохранение в png
                FileFilter extensionFilter =
                new FileNameExtensionFilter("PNG Images", "png");
                myFileChooser.setFileFilter(extensionFilter);

                // защита от сохранения не пнгшки
                myFileChooser.setAcceptAllFileFilterUsed(false);
                
                // директория для сохранения
                int userSelection = myFileChooser.showSaveDialog(display);
                
                // если результатом операции выбора файла является
                // APPROVE_OPTION, продолжить сохранение
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    
                    // название сохраняемому файлу
                    java.io.File file = myFileChooser.getSelectedFile();
                    String file_name = file.toString();
                    
                    // попытка сохранить фрактал на диск
                    try {
                        BufferedImage displayImage = display.getImage();
                        javax.imageio.ImageIO.write(displayImage, "png", file);
                    }
                    // поимка исключений и вывод ошибки
                    catch (Exception exception) {
                        JOptionPane.showMessageDialog(display,
                        exception.getMessage(), "Cannot Save Image",
                        JOptionPane.ERROR_MESSAGE);
                    }
                }
                // если выбор в диалоговок окне не прошел успешно, вернуть false
                else return;
            }
        }
    }

    //Обработчик событий MouseListener с дисплея
    private class MouseHandler extends MouseAdapter
    {
        //Когда обработчик получает событие щелчка мыши,
        // он отображает пиксельные координаты щелчка в область отображаемого фрактала,
        // а затем вызывает метод recenterAndZoomRange() генератора с координатами,
        // которые были нажаты, и масштабом 0,5.
        @Override
        public void mouseClicked(MouseEvent e)
        {
            // возвращаем, rowsRemaining если не нулевой
            if (rowsRemaining != 0) {
                return;
            }
            // х координата клика
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x,
            range.x + range.width, displaySize, x);
            
            // у координата клика
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,
            range.y + range.height, displaySize, y);
            
            // Вызовите метод recenterAndZoomRange() генератора с
            // координатами, которые были нажаты, и шкалой 0,5.
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            
            // перерисовка фрактала после изменения отображаемой области
            drawFractal();
        }
    }
    
    // Вычисляет значения цвета для одной строки фрактала.
    private class FractalWorker extends SwingWorker<Object, Object>
    {
        // поле у координаты, которая будет вычислена
        int yCoordinate;
        
        //хранение вычисленных значений RGB для каждого пикселя в строке
        int[] computedRGBValues;
        
        //принимает координату y в качестве аргумента и сохраняет ее
        private FractalWorker(int row) {
            yCoordinate = row;
        }
        
        // вызывается в фоновом потоке. Вычисляет значение RGB для всех пикселей
        // в 1 строке и сохраняет его в соответствующем элементе целочисленного массива.
        // Возвращает null.
        protected Object doInBackground() {
            
            computedRGBValues = new int[displaySize];
            
            // повторить все пиксели в строке
            for (int i = 0; i < computedRGBValues.length; i++) {

                // Находит соответствующие координаты xCoord и yCoord в области отображения фрактала.
                double xCoord = fractal.getCoord(range.x,
                range.x + range.width, displaySize, i);
                double yCoord = fractal.getCoord(range.y,
                range.y + range.height, displaySize, yCoordinate);
            
                // считает количество итераций для координат в области отображения фрактала.
                int iteration = fractal.numIterations(xCoord, yCoord);
                        
                // если число итераций равно -1,
                // установит текущий int в вычисленном массиве
                // RGB values int в черный цвет.
                if (iteration == -1){
                    computedRGBValues[i] = 0;
                }
            
                else {
                    // если нет, выбервет значение оттенка, основанное на количестве итераций.
                    float hue = 0.7f + (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                
                    // обновляет массив int цветом текущего пикселя.
                    computedRGBValues[i] = rgbColor;
                }
            }
            return null;
            
        }
        //Вызывается после завершения фоновой задачи.
        // Рисует пиксели для текущей строки и обновляет отображение для этой строки.
        protected void done() {
            // Повторяет итерацию по массиву данных строк, рисуя пиксели,
            // которые были вычислены в doInBackground().
            // Перерисовывает строку, которая была изменена.
            for (int i = 0; i < computedRGBValues.length; i++) {
                display.drawPixel(i, yCoordinate, computedRGBValues[i]);
            }
            display.repaint(0, 0, yCoordinate, displaySize, 1);

            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
    }

    //Создаем экземпляр и рисуем фрактал
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
    
}