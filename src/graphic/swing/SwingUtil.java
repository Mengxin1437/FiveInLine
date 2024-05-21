package graphic.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**Title: SwingUtil.java
 * Swing工具类
 *
 * @author Run
 * @date  2019-08-20 */
public class SwingUtil {

    /**创建一个可以自适应组件大小的ImageIcon对象
     * @param image 从<code> Image </code>对象来创建ImageIcon
     * @param constrained 是否等比例缩放 。当为<code> true </code>时，可通过
     *      {@link javax.swing.JComponent#setAlignmentX(float)}和
     *      {@link javax.swing.JComponent#setAlignmentY(float)}方法设置组件对齐方式。
     * @date  2019-08-20 */
    public static ImageIcon createAutoAdjustIcon(Image image, boolean constrained) {
        ImageIcon icon = new ImageIcon(image) {
            @Override
            public synchronized void paintIcon(java.awt.Component cmp, Graphics g, int x, int y) {
                //初始化参数
                Point startPoint = new Point(0, 0);//默认绘制起点
                Dimension cmpSize = cmp.getSize();//获取组件大小
                Dimension imgSize = new Dimension(getIconWidth(), getIconHeight());//获取图像大小

                //计算绘制起点和区域
                if(constrained) {//等比例缩放
                    //计算图像宽高比例
                    double ratio = 1.0*imgSize.width/imgSize.height;
                    //计算等比例缩放后的区域大小
                    imgSize.width = (int) Math.min(cmpSize.width, ratio*cmpSize.height);
                    imgSize.height = (int) (imgSize.width/ratio);
                    //计算绘制起点
                    startPoint.x = (int)
                            (cmp.getAlignmentX()*(cmpSize.width - imgSize.width));
                    startPoint.y = (int)
                            (cmp.getAlignmentY()*(cmpSize.height - imgSize.height));
                } else {//完全填充
                    imgSize = cmpSize;
                }

                //根据起点和区域大小进行绘制
                if(getImageObserver() == null) {
                    g.drawImage(getImage(), startPoint.x, startPoint.y,
                            imgSize.width, imgSize.height, cmp);
                } else {
                    g.drawImage(getImage(), startPoint.x, startPoint.y,
                            imgSize.width, imgSize.height, getImageObserver());
                }
            };
        };
        return icon;
    }

    /**创建一个可以自适应组件大小的Icon对象
     * @param filename 指定文件名或者路径的字符串
     * @param constrained 是否等比例缩放。当为<code> true </code>时，可通过
     *      {@link javax.swing.JComponent#setAlignmentX(float)}和
     *      {@link javax.swing.JComponent#setAlignmentY(float)}方法设置组件对齐方式。
     * @date  2019-08-20 */
    public static ImageIcon createAutoAdjustIcon(String filename, boolean constrained) {
        return createAutoAdjustIcon(new ImageIcon(filename).getImage(), constrained);
    }

    /**创建一个可以自适应组件大小的ImageIcon对象
     * @param url 从指定的<code> URL </code>对象来创建ImageIcon
     * @param constrained 是否等比例缩放 。当为<code> true </code>时，可通过
     *      {@link javax.swing.JComponent#setAlignmentX(float)}和
     *      {@link javax.swing.JComponent#setAlignmentY(float)}方法设置组件对齐方式。
     * @date  2019-08-20 */
    public static ImageIcon createAutoAdjustIcon(URL url, boolean constrained) {
        return createAutoAdjustIcon(new ImageIcon(url).getImage(), constrained);
    }

    /**
     * 通过组件名,从父级组件沿着递归找到此名字的组件
     *
     * @param c		父级组件
     * @param name	设置的组件名称
     * @return
     */
    public static Component searchComponentByName(Container c,String name){//父级组件,设置的组件名称
        Component result = null;
        Component[] components = c.getComponents();
//        for(Component co: components){
//            System.out.println(co.getName());
//        }
        if( null == result &&  null != components && components.length > 0){
            for (Component component : components) {
                String name2 = component.getName();
                if(name2 != null && name2.equals(name)){
                    result = component;
                    return result;
                }else if(null == result){//递归调用所有下级组件列表
                    if(component instanceof Container)
                        result = searchComponentByName((Container)component, name);
                }
            }
        }
        return result;
    }
    /**
     * 不使用instanceof 判断是否是同一种类型,
     * 判断目标类型和源类型的字节码对象(Class)是否是同一种类型
     * 通过class类的toString 方法,判断打印出来的类型是否相等,或者直接判断
     *
     * @param c
     * @param t
     * @return
     */
    public static <T extends Component> Component searchComponentByClass(Container c,Class<T> t){//泛型方法
        Component result = null;
        Component[] components = c.getComponents();
        if( null == result &&  null != components && components.length > 0){
            for (Component component : components) {
                //if(component instanceof t){//发现泛型无法作为instanceof右边的对象,无法在运行时将泛型替换为对应的对象
                if(component.getClass().equals(t)){
                    //if(component.getClass().toString().equals(t.toString()))			和上一行代码效果相同
                    result = component;
                    return result;
                }else if(null == result){//递归调用所有下级组件列表
                    if(component instanceof Container)
                        result = searchComponentByClass((Container)component, t);
                }
            }
        }
        return result;
    }
}


