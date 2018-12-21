package basic.sprites;

import javafx.scene.canvas.GraphicsContext;

public abstract class Sprite implements Comparable<Sprite> {


  int x;
  int y;
  int z;

  public Sprite(Sprite sprite) {
    this.x = sprite.x;
    this.y = sprite.y;
    this.z = sprite.z;
    this.xSpeed = sprite.xSpeed;
    this.ySpeed = sprite.ySpeed;
  }

  public int getX() {
    return x;
  }
  private int xSpeed;
  private int ySpeed;

  public int getY() {
    return y;
  }

  public Sprite(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void updatePosition() {
    x += xSpeed;
    y += ySpeed;
  }

  public void setSpeed(int xSpeed, int ySpeed) {
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  public abstract void render(GraphicsContext gc);

  public abstract boolean contains(int x, int y);

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sprite sprite = (Sprite) o;
    return this.x == sprite.x
        && this.y == sprite.y;
  }

  public String toString() {
    return "Sprite<" + this.x + "," + this.y + "," + this.z + ">";
  }

  @Override
  public int compareTo(Sprite sprite) {
    return this.z - sprite.z;
  }
}