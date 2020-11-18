Public Class clsTri
    Private Lines As List(Of clsLine) ' 约定3个

    Public Sub New(ByVal vs As List(Of clsVertex))
        Lines = New List(Of clsLine)
        Lines.Add(New clsLine(vs(0), vs(1)))
        Lines.Add(New clsLine(vs(1), vs(2)))
        Lines.Add(New clsLine(vs(2), vs(0)))
    End Sub
    Public Sub Draw(ByVal g As Graphics)
        For i = 0 To Lines.Count - 1
            Lines(i).Draw(g)
        Next
    End Sub

End Class
