package com.ivieleague.kotlin.javafx

import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.*


class _StackPane : StackPane() {
    val Node.lparams get() = StackPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: StackPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _BorderPane : BorderPane() {
    val Node.lparams get() = BorderPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: BorderPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _HBox : HBox() {
    val Node.lparams get() = HBoxLayoutParams(this)
    fun <T : Node> T.lparams(setup: HBoxLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _VBox : VBox() {
    val Node.lparams get() = VBoxLayoutParams(this)
    fun <T : Node> T.lparams(setup: VBoxLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _GridPane : GridPane() {
    val Node.lparams get() = GridPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: GridPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _FlowPane : FlowPane() {
    val Node.lparams get() = FlowPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: FlowPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _TilePane : TilePane() {
    val Node.lparams get() = TilePaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: TilePaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _AnchorPane : AnchorPane() {
    val Node.lparams get() = AnchorPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: AnchorPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _TabPane : TabPane() {
    val Node.lparams get() = object {}
    fun <T : Node> T.lparams(setup: Any.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _ScrollPane : ScrollPane() {
    val Node.lparams get() = object {}
    fun <T : Node> T.lparams(setup: Any.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _SplitPane : SplitPane() {
    val Node.lparams get() = SplitPaneLayoutParams(this)
    fun <T : Node> T.lparams(setup: SplitPaneLayoutParams.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

class _TitledPane : TitledPane() {
    val Node.lparams get() = object {}
    fun <T : Node> T.lparams(setup: Any.() -> Unit): T {
        lparams.apply(setup); return this
    }
}

fun Pane.stackPane(setup: _SplitPane.() -> Unit) = _SplitPane().apply(setup).also { children += it }
fun Pane.borderPane(setup: _BorderPane.() -> Unit) = _BorderPane().apply(setup).also { children += it }
fun Pane.hBox(setup: _HBox.() -> Unit) = _HBox().apply(setup).also { children += it }
fun Pane.vBox(setup: _VBox.() -> Unit) = _VBox().apply(setup).also { children += it }
fun Pane.gridPane(setup: _GridPane.() -> Unit) = _GridPane().apply(setup).also { children += it }
fun Pane.flowPane(setup: _FlowPane.() -> Unit) = _FlowPane().apply(setup).also { children += it }
fun Pane.tilePane(setup: _TilePane.() -> Unit) = _TilePane().apply(setup).also { children += it }
fun Pane.anchorPane(setup: _AnchorPane.() -> Unit) = _AnchorPane().apply(setup).also { children += it }
fun Pane.tabPane(setup: _TabPane.() -> Unit) = _TabPane().apply(setup).also { children += it }
fun Pane.scrollPane(setup: _ScrollPane.() -> Unit) = _ScrollPane().apply(setup).also { children += it }
fun Pane.splitPane(setup: _SplitPane.() -> Unit) = _SplitPane().apply(setup).also { children += it }
fun Pane.titledPane(setup: _TitledPane.() -> Unit) = _TitledPane().apply(setup).also { children += it }

fun StackPane.lparams(node: Node) = StackPaneLayoutParams(node)
class StackPaneLayoutParams(val node: Node) {
    var alignment: Pos?
        get() = StackPane.getAlignment(node)
        set(value) {
            StackPane.setAlignment(node, value)
        }
    var margin: Insets?
        get() = StackPane.getMargin(node)
        set(value) {
            StackPane.setMargin(node, value)
        }
}

fun BorderPane.lparams(node: Node) = BorderPaneLayoutParams(node)
class BorderPaneLayoutParams(val node: Node) {
    var alignment: Pos?
        get() = BorderPane.getAlignment(node)
        set(value) {
            BorderPane.setAlignment(node, value)
        }
    var margin: Insets?
        get() = BorderPane.getMargin(node)
        set(value) {
            BorderPane.setMargin(node, value)
        }
}

fun HBox.lparams(node: Node) = HBoxLayoutParams(node)
class HBoxLayoutParams(val node: Node) {
    var grow: Priority?
        get() = HBox.getHgrow(node)
        set(value) {
            HBox.setHgrow(node, value)
        }
    var margin: Insets?
        get() = HBox.getMargin(node)
        set(value) {
            HBox.setMargin(node, value)
        }
}

fun VBox.lparams(node: Node) = VBoxLayoutParams(node)
class VBoxLayoutParams(val node: Node) {
    var grow: Priority?
        get() = VBox.getVgrow(node)
        set(value) {
            VBox.setVgrow(node, value)
        }
    var margin: Insets?
        get() = VBox.getMargin(node)
        set(value) {
            VBox.setMargin(node, value)
        }
}

fun GridPane.lparams(node: Node) = GridPaneLayoutParams(node)
class GridPaneLayoutParams(val node: Node) {
    var halignment: HPos?
        get() = GridPane.getHalignment(node)
        set(value) = GridPane.setHalignment(node, value)
    var valignment: VPos?
        get() = GridPane.getValignment(node)
        set(value) = GridPane.setValignment(node, value)
    var hgrow: Priority?
        get() = GridPane.getHgrow(node)
        set(value) = GridPane.setHgrow(node, value)
    var vgrow: Priority?
        get() = GridPane.getVgrow(node)
        set(value) = GridPane.setVgrow(node, value)
    var fillWidth: Boolean?
        get() = throw IllegalAccessException()
        set(value) = GridPane.setFillWidth(node, value)
    var fillHeight: Boolean?
        get() = throw IllegalAccessException()
        set(value) = GridPane.setFillHeight(node, value)
    var rowIndex: Int?
        get() = GridPane.getRowIndex(node)
        set(value) = GridPane.setRowIndex(node, value)
    var columnIndex: Int?
        get() = GridPane.getColumnIndex(node)
        set(value) = GridPane.setColumnIndex(node, value)
    var rowSpan: Int?
        get() = GridPane.getRowSpan(node)
        set(value) = GridPane.setRowSpan(node, value)
    var columnSpan: Int?
        get() = GridPane.getColumnSpan(node)
        set(value) = GridPane.setColumnSpan(node, value)
}

fun FlowPane.lparams(node: Node) = FlowPaneLayoutParams(node)
class FlowPaneLayoutParams(val node: Node) {
    var margin: Insets?
        get() = FlowPane.getMargin(node)
        set(value) {
            FlowPane.setMargin(node, value)
        }
}

fun TilePane.lparams(node: Node) = TilePaneLayoutParams(node)
class TilePaneLayoutParams(val node: Node) {
    var alignment: Pos?
        get() = TilePane.getAlignment(node)
        set(value) {
            TilePane.setAlignment(node, value)
        }
    var margin: Insets?
        get() = TilePane.getMargin(node)
        set(value) {
            TilePane.setMargin(node, value)
        }
}

fun AnchorPane.lparams(node: Node) = AnchorPaneLayoutParams(node)
class AnchorPaneLayoutParams(val node: Node) {
    var topAnchor: Double?
        get() = AnchorPane.getTopAnchor(node)
        set(value) {
            AnchorPane.setTopAnchor(node, value)
        }
    var leftAnchor: Double?
        get() = AnchorPane.getLeftAnchor(node)
        set(value) {
            AnchorPane.setLeftAnchor(node, value)
        }
    var bottomAnchor: Double?
        get() = AnchorPane.getBottomAnchor(node)
        set(value) {
            AnchorPane.setBottomAnchor(node, value)
        }
    var rightAnchor: Double?
        get() = AnchorPane.getRightAnchor(node)
        set(value) {
            AnchorPane.setRightAnchor(node, value)
        }
}

fun SplitPane.lparams(node: Node) = SplitPaneLayoutParams(node)
class SplitPaneLayoutParams(val node: Node) {
    var resizableWithParent
        get() = SplitPane.isResizableWithParent(node)
        set(value) {
            SplitPane.setResizableWithParent(node, value)
        }
}


fun TabPane.lparams(node: Node) = object {}
fun ScrollPane.lparams(node: Node) = object {}
fun TitledPane.lparams(node: Node) = object {}

fun Pane.button(setup: Button.() -> Unit) = Button().apply(setup).also { children += it }
fun Pane.checkBox(setup: CheckBox.() -> Unit) = CheckBox().apply(setup).also { children += it }
fun Pane.colorPicker(setup: ColorPicker.() -> Unit) = ColorPicker().apply(setup).also { children += it }
fun Pane.hyperlink(setup: Hyperlink.() -> Unit) = Hyperlink().apply(setup).also { children += it }
fun Pane.label(setup: Label.() -> Unit) = Label().apply(setup).also { children += it }
fun Pane.menuBar(setup: MenuBar.() -> Unit) = MenuBar().apply(setup).also { children += it }
fun Pane.menuButton(setup: MenuButton.() -> Unit) = MenuButton().apply(setup).also { children += it }
fun Pane.pagination(setup: Pagination.() -> Unit) = Pagination().apply(setup).also { children += it }
fun Pane.passwordField(setup: PasswordField.() -> Unit) = PasswordField().apply(setup).also { children += it }
fun Pane.progressBar(setup: ProgressBar.() -> Unit) = ProgressBar().apply(setup).also { children += it }
fun Pane.progressIndicator(setup: ProgressIndicator.() -> Unit) = ProgressIndicator().apply(setup).also { children += it }
fun Pane.radioButton(setup: RadioButton.() -> Unit) = RadioButton().apply(setup).also { children += it }
fun Pane.scrollBar(setup: ScrollBar.() -> Unit) = ScrollBar().apply(setup).also { children += it }
fun Pane.separator(setup: Separator.() -> Unit) = Separator().apply(setup).also { children += it }
fun Pane.slider(setup: Slider.() -> Unit) = Slider().apply(setup).also { children += it }
fun Pane.splitMenuButton(setup: SplitMenuButton.() -> Unit) = SplitMenuButton().apply(setup).also { children += it }
fun Pane.textArea(setup: TextArea.() -> Unit) = TextArea().apply(setup).also { children += it }
fun Pane.textField(setup: TextField.() -> Unit) = TextField().apply(setup).also { children += it }
fun Pane.toolBar(setup: ToolBar.() -> Unit) = ToolBar().apply(setup).also { children += it }

fun Menu.menuItem(setup: MenuItem.() -> Unit) = MenuItem().apply(setup).also { items += it }
fun Menu.menu(setup: Menu.() -> Unit) = Menu().apply(setup).also { items += it }
fun Menu.radioMenuItem(setup: RadioMenuItem.() -> Unit) = RadioMenuItem().apply(setup).also { items += it }
fun Menu.separatorMenuItem(setup: SeparatorMenuItem.() -> Unit) = SeparatorMenuItem().apply(setup).also { items += it }

fun TabPane.tab(setup: Tab.() -> Unit) = Tab().apply(setup).also { tabs += it }

fun <T> Pane.listView(setup: ListView<T>.() -> Unit) = ListView<T>().apply(setup).also { children += it }
fun <T> Pane.listView(list: ObservableList<T>, setup: ListView<T>.() -> Unit) = ListView<T>().apply { items = list }.apply(setup).also { children += it }
fun <T> Pane.tableView(setup: TableView<T>.() -> Unit) = TableView<T>().apply(setup).also { children += it }
fun <T> Pane.tableView(list: ObservableList<T>, setup: TableView<T>.() -> Unit) = TableView<T>().apply { items = list }.apply(setup).also { children += it }
fun <T> Pane.choiceBox(setup: ChoiceBox<T>.() -> Unit) = ChoiceBox<T>().apply(setup).also { children += it }
fun <T> Pane.choiceBox(list: ObservableList<T>, setup: ChoiceBox<T>.() -> Unit) = ChoiceBox<T>().apply { items = list }.apply(setup).also { children += it }
fun <T> Pane.comboBox(setup: ComboBox<T>.() -> Unit) = ComboBox<T>().apply(setup).also { children += it }
fun <T> Pane.comboBox(list: ObservableList<T>, setup: ComboBox<T>.() -> Unit) = ComboBox<T>().apply { items = list }.apply(setup).also { children += it }
fun <T> Pane.treeView(setup: TreeView<T>.() -> Unit) = TreeView<T>().apply(setup).also { children += it }