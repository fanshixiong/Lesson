<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmTest
    Inherits System.Windows.Forms.Form

    'Form 重写 Dispose，以清理组件列表。
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Windows 窗体设计器所必需的
    Private components As System.ComponentModel.IContainer

    '注意: 以下过程是 Windows 窗体设计器所必需的
    '可以使用 Windows 窗体设计器修改它。
    '不要使用代码编辑器修改它。
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.lstInfo = New System.Windows.Forms.ListBox()
        Me.picCanvas = New System.Windows.Forms.PictureBox()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.rbLine = New System.Windows.Forms.RadioButton()
        Me.rbCircle = New System.Windows.Forms.RadioButton()
        CType(Me.picCanvas, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'lstInfo
        '
        Me.lstInfo.FormattingEnabled = True
        Me.lstInfo.ItemHeight = 16
        Me.lstInfo.Location = New System.Drawing.Point(13, 120)
        Me.lstInfo.Margin = New System.Windows.Forms.Padding(4)
        Me.lstInfo.Name = "lstInfo"
        Me.lstInfo.Size = New System.Drawing.Size(233, 196)
        Me.lstInfo.TabIndex = 1
        '
        'picCanvas
        '
        Me.picCanvas.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.picCanvas.Location = New System.Drawing.Point(253, 65)
        Me.picCanvas.Name = "picCanvas"
        Me.picCanvas.Size = New System.Drawing.Size(526, 332)
        Me.picCanvas.TabIndex = 2
        Me.picCanvas.TabStop = False
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(299, 20)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(113, 28)
        Me.Button1.TabIndex = 3
        Me.Button1.Text = "Button1"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'rbLine
        '
        Me.rbLine.AutoSize = True
        Me.rbLine.Location = New System.Drawing.Point(33, 24)
        Me.rbLine.Name = "rbLine"
        Me.rbLine.Size = New System.Drawing.Size(58, 20)
        Me.rbLine.TabIndex = 4
        Me.rbLine.TabStop = True
        Me.rbLine.Text = "Line"
        Me.rbLine.UseVisualStyleBackColor = True
        '
        'rbCircle
        '
        Me.rbCircle.AutoSize = True
        Me.rbCircle.Location = New System.Drawing.Point(33, 50)
        Me.rbCircle.Name = "rbCircle"
        Me.rbCircle.Size = New System.Drawing.Size(74, 20)
        Me.rbCircle.TabIndex = 4
        Me.rbCircle.TabStop = True
        Me.rbCircle.Text = "Circle"
        Me.rbCircle.UseVisualStyleBackColor = True
        '
        'frmTest
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(749, 457)
        Me.Controls.Add(Me.rbCircle)
        Me.Controls.Add(Me.rbLine)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.picCanvas)
        Me.Controls.Add(Me.lstInfo)
        Me.Font = New System.Drawing.Font("宋体", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(134, Byte))
        Me.Margin = New System.Windows.Forms.Padding(4)
        Me.Name = "frmTest"
        Me.Text = "Form1"
        CType(Me.picCanvas, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents lstInfo As System.Windows.Forms.ListBox
    Friend WithEvents picCanvas As System.Windows.Forms.PictureBox
    Friend WithEvents Button1 As System.Windows.Forms.Button
    Friend WithEvents rbLine As System.Windows.Forms.RadioButton
    Friend WithEvents rbCircle As System.Windows.Forms.RadioButton

End Class
