import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)
    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field // 뒷받침하는 필드에 접근할때 field 식별자를 사용한다.
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }
    var salary: Int = salary
        set(newValue) {
            val oldValue = field // 뒷받침하는 필드에 접근할때 field 식별자를 사용한다.
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

val p = Person("Dmity", 34, 2000)
p.addPropertyChangeListener(
    PropertyChangeListener { event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    }
)

p.age = 35
p.salary = 2100
