package game.view.mapView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.main.Jeu;


    public class MapView extends JPanel implements MouseMotionListener, MouseListener {

		private static final long serialVersionUID = 1L;
		
		private BufferedImage BackImage;
        BufferedImage GrassTilePlaine, GrassTileMontagne, GrassTileChamps, SelectedBorder;
        private Point MousePoint, PrevView, ViewLocation, Selected;
        private boolean Dragging;
        private int mapwidth, mapheight, tilecount;
        
        private int [][] typeCell = {
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        		{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        		
        };

        public MapView() {
            super();
            this.setOpaque(true);
            createAssets();
            tilecount = Jeu.getInstance().getCurrent_partie().getCarte().getDimension();
            mapwidth = GrassTilePlaine.getWidth() * tilecount;
            mapheight = GrassTilePlaine.getHeight() * tilecount;
            ViewLocation = new Point(0, mapheight / 2);
            Selected = new Point(-1, -1);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        private void createAssets() {
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            GrassTilePlaine = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            Graphics g = GrassTilePlaine.getGraphics();
            
            GrassTileMontagne = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            Graphics g1 = GrassTileMontagne.getGraphics();
            
            GrassTileChamps = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            Graphics g2 = GrassTileChamps.getGraphics();

            Polygon poly = new Polygon();
            poly.addPoint(0, 32);
            poly.addPoint(64, 0);
            poly.addPoint(128, 32);
            poly.addPoint(64, 64);

            g.setColor(Color.GREEN);		
            g.fillPolygon(poly);
            g.setColor(Color.BLUE);
            g.drawPolygon(poly);
            g.dispose();
            SelectedBorder = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            g = SelectedBorder.getGraphics();
            g.setColor(Color.red);
            g.drawPolygon(poly);
            g.dispose();
            
            g1.setColor(Color.GRAY);
            g1.fillPolygon(poly);
            g1.setColor(Color.BLUE);
            g1.drawPolygon(poly);
            g1.dispose();
            SelectedBorder = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            g1 = SelectedBorder.getGraphics();
            g1.setColor(Color.red);
            g1.drawPolygon(poly);
            g1.dispose();
            
            g2.setColor(Color.YELLOW);
            g2.fillPolygon(poly);
            g2.setColor(Color.BLUE);
            g2.drawPolygon(poly);
            g2.dispose();
            SelectedBorder = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            g2 = SelectedBorder.getGraphics();
            g2.setColor(Color.red);
            g2.drawPolygon(poly);
            g2.dispose();
            
            /*g.setColor(Color.BLUE);
            g.drawPolygon(poly);
            g.dispose();
            SelectedBorder = gc.createCompatibleImage(128, 64, Transparency.TRANSLUCENT);
            g = SelectedBorder.getGraphics();
            g.setColor(Color.red);
            g.drawPolygon(poly);
            g.dispose();*/
        }

        @Override
        public void paint(Graphics g) {
            Rectangle visiblerec = this.getVisibleRect();
            g.setColor(Color.BLACK);
            g.fillRect(visiblerec.x, visiblerec.y, visiblerec.width, visiblerec.height);
            checkBackImage();
            Graphics bg = BackImage.getGraphics();
            drawGrassGrid(bg);
            bg.dispose();
            g.drawImage(BackImage, 0, 0, this);
        }

        private void drawGrassGrid(Graphics g) {
            int dx = 0;
            int dy = 0;
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, BackImage.getWidth(), BackImage.getHeight());
            for (int x = 0; x < tilecount; x++) {
                for (int y = 0; y < tilecount; y++) {
                    dx = x * GrassTilePlaine.getWidth() / 2 - y * GrassTilePlaine.getWidth() / 2;
                    dy = x * GrassTilePlaine.getHeight() / 2 + y * GrassTilePlaine.getHeight() / 2;

                    dx -= ViewLocation.x;
                    dy -= ViewLocation.y;

                    if(typeCell[y][x] == 0)
                    	g.drawImage(GrassTilePlaine, dx, dy, this);
                    else if (typeCell[y][x] == 1)
                    	g.drawImage(GrassTileChamps, dx, dy, this);
                    else
                    	g.drawImage(GrassTileMontagne, dx, dy, this);

                    if ((x == Selected.x) && (y == Selected.y)) {
                        g.drawImage(SelectedBorder, dx, dy, this);
                    }
                    g.drawString("(" + x + "," + y + ")", dx, dy + GrassTilePlaine.getHeight() / 2);
                }
            }
        }

        private void checkBackImage() {
            if ((BackImage == null) || (BackImage.getWidth() != this.getWidth())
                    || (BackImage.getHeight() != this.getHeight())) {
                GraphicsConfiguration gc =
                        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
                BackImage = gc.createCompatibleImage(this.getWidth(), this.getHeight(), Transparency.BITMASK);
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (Dragging) {
                ViewLocation.x = PrevView.x + MousePoint.x - e.getX();
                ViewLocation.y = PrevView.y + MousePoint.y - e.getY();
                if (ViewLocation.x < -mapwidth / 2) {
                    ViewLocation.x = -mapwidth / 2;
                }
                if (ViewLocation.y < -mapheight / 2 + this.getHeight()) {
                    ViewLocation.y = -mapheight / 2 + this.getHeight();
                }
                if (ViewLocation.x > mapwidth / 2 - this.getWidth()
                        + GrassTilePlaine.getWidth()) {
                    ViewLocation.x = mapwidth / 2 - this.getWidth()
                            + GrassTilePlaine.getWidth();
                }
                if (ViewLocation.y > mapheight / 2 + this.getHeight()) {
                    ViewLocation.y = mapheight / 2 + this.getHeight();
                }
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!Dragging) {            	
            	int pickX = e.getX() + ViewLocation.x;
                int pickY = e.getY() + ViewLocation.y;
                int tileW = GrassTilePlaine.getWidth();
                int tileH = GrassTilePlaine.getHeight();
                
                int hitx = (int)(((double)pickX / (double)tileW) + ((double)pickY / (double)tileH) - 0.5);
                int hity = (int)(((double)pickY / (double)tileH) - ((double)pickX / (double)tileW) + 0.5);

                Selected.setLocation(hitx, hity);
                repaint();
                System.out.println("(" + hitx + "," + hity + ")");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if ((e.getButton() == MouseEvent.BUTTON1) && !Dragging) {
                MousePoint = e.getPoint();
                PrevView = new Point(ViewLocation);
                Dragging = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Dragging = false;
            MousePoint = null;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }//MapViewPane

